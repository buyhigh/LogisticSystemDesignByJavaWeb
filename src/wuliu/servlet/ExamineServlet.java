package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.DispatchDao;
import wuliu.dao.GoodsDao;
import wuliu.dao.OutStoreRequestDao;
import wuliu.dao.StateDao;
import wuliu.dao.StoreRefGoodDao;
import wuliu.dao.TransferModelDao;
import wuliu.dao.TransferRequestDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.GoodsDaoImpl;
import wuliu.dao.impl.OutStoreRequestDaoImpl;
import wuliu.dao.impl.StateDaoImpl;
import wuliu.dao.impl.StoreRefGoodDaoImpl;
import wuliu.dao.impl.TransferModelDaoImpl;
import wuliu.dao.impl.TransferRequestDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.DispatchDto;
import wuliu.dto.GoodsDto;
import wuliu.dto.TransferToolDto;
import wuliu.entity.Dispatch;
import wuliu.entity.OutStoreRequest;
import wuliu.entity.StoreRefGood;
import wuliu.entity.TransferModel;
import wuliu.entity.TransferRequest;

public class ExamineServlet extends HttpServlet {

	private static final long serialVersionUID = -4144120819315118960L;
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	private StateDao stateDao = new StateDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	private OutStoreRequestDao outStoreRequestDao = new OutStoreRequestDaoImpl();
	private TransferRequestDao transferRequestDao = new TransferRequestDaoImpl();
	private GoodsDao goodsDao = new GoodsDaoImpl();
	private TransferModelDao transferModelDao = new TransferModelDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		int pageNum = 1;//��ǰҳ��
		int maxPage = 1;//���ҳ��
		int rowCount = 0;
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		int state = stateDao.getStateByName("δ���").getStateId();
		List<DispatchDto> listDispatchDto = dispatchDao.getDispatchByState(state,pageNum);
		rowCount = dispatchDao.getDispatchCount(state);
		if(rowCount % 10 == 0){
			maxPage = rowCount / 10;
		}else{
			maxPage = rowCount / 10 + 1;
		}
		request.setAttribute("curPage", pageNum);
		request.setAttribute("maxPage",maxPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("listDispatchDto", listDispatchDto);
		request.getRequestDispatcher("/jd/jd_shenhepeisongdan.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String operateStr = request.getParameter("operate");
		int operate = -1;
		if(operateStr != null && !operateStr.equals("")){
			operate = Integer.parseInt(operateStr);
		}
		System.out.println("���͵����debug1");
		
		String[] dispatchIdList = request.getParameterValues("chkItem");//����˻��ɾ��������֪ͨ��ID�б�
		switch(operate){
		case 1:
			//ɾ������
			dispatchDao.deleteDispatchByIdList(dispatchIdList);
			int state = stateDao.getStateByName("δ���").getStateId();
			List<DispatchDto> listDispatchDto = dispatchDao.getDispatchByState(state);
			request.setAttribute("listDispatchDto", listDispatchDto);
			request.getRequestDispatcher("/jd/jd_shenhepeisongdan.jsp").forward(request, response);
			break;
		case 2:
			//��˲���
			System.out.println("�������͵����");
			for(int i = 0 ; i < dispatchIdList.length ; i++){
				//��ȡ����˵�����֪ͨ��
				Dispatch dispatch = dispatchDao.getDispatchById(Integer.parseInt(dispatchIdList[i]));
				StoreRefGood storeRefGood = storeRefGoodDao.examineDispatch(dispatch.getGoodName(), dispatch.getGoodQuantity());
				//���ͨ��
				if(storeRefGood != null){//����������㷢�������������˵�ͨ��
					
					//�޸�����֪ͨ��״̬Ϊ"�����δִ��"
					dispatchDao.updateDispatchState(dispatch.getDispatchId(), 2);
					//�޸�����֪ͨ��״̬
					
					
					//���ɳ�������
					OutStoreRequest outStoreRequest = new OutStoreRequest();
					outStoreRequest.setDispatchId(dispatch.getDispatchId());
					outStoreRequest.setStoreId(storeRefGood.getStoreId());
					outStoreRequest.setState(1);
					outStoreRequestDao.addOutStoreRequest(outStoreRequest);//���ɳ�������
					//���ɳ�������
					
					
					//������������
					//��ȡ��Ҫ�������Ʒ��Ϣ�����������أ��������������Ҫ�ĳ�����Ŀ
					GoodsDto goodsDto = goodsDao.getGoodByGoodName(dispatch.getGoodName()).get(0);
					double reqWeight = dispatch.getGoodQuantity() * Double.parseDouble(goodsDto.getGoodWeight()) / 2000;//���������
					double reqMulk = dispatch.getGoodQuantity() * Double.parseDouble(goodsDto.getGoodBulk()) / 1000000;//����Ŀռ�
					//��ȡ���䳵��������Ϣ
					TransferToolDto transferToolDto = transferToolDao.getTransferToolById(dispatch.getTransferTool());
					TransferModel transferModel = transferModelDao.getTransferModelById(transferToolDto.getTransferModel());
					double factWeight = Double.parseDouble(transferModel.getTrmoWeight());
					double factMulk = Double.parseDouble(transferModel.getTrmoMulk());
					TransferRequest transferRequest = new TransferRequest();
					transferRequest.setDispatchId(dispatch.getDispatchId());
					transferRequest.setTransferToolId(dispatch.getTransferTool());
					transferRequest.setState(1);
					int requestNum = 1;
					while(reqWeight > factWeight || reqMulk > factMulk){
						requestNum++;
						factWeight += factWeight;
						factMulk += factMulk;
					}
					transferRequest.setRequestNum(requestNum);
					transferRequestDao.addTransferRequest(transferRequest);//������������
					//������������
				}else{
					//���δͨ��,�޸�����֪ͨ����״̬Ϊ"δ��������"
					dispatchDao.updateDispatchState(dispatch.getDispatchId(), 3);
				}
			}
			break;
		}
		response.sendRedirect("querydispatch");
		
	}

}
