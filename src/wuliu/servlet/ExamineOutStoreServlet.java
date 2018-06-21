package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.OutStoreRequestDao;
import wuliu.dao.StoreRefGoodDao;
import wuliu.dao.impl.OutStoreRequestDaoImpl;
import wuliu.dao.impl.StoreRefGoodDaoImpl;
import wuliu.dto.OutStoreRequestDto;
import wuliu.entity.OutStoreTask;
import wuliu.entity.StoreRefGood;

import wuliu.dao.OutStoreRequestDao;
import wuliu.dao.OutStoreTaskDao;
import wuliu.dao.SendTraTaskDao;
import wuliu.dao.StoreRefGoodDao;
import wuliu.dao.TransferRequestDao;
import wuliu.dao.TransferTaskDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.OutStoreRequestDaoImpl;
import wuliu.dao.impl.OutStoreTaskDaoImpl;
import wuliu.dao.impl.SendTraTaskDaoImpl;
import wuliu.dao.impl.StoreRefGoodDaoImpl;
import wuliu.dao.impl.TransferRequestDaoImpl;
import wuliu.dao.impl.TransferTaskDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.OutStoreRequestDto;
import wuliu.dto.OutStoreTaskDto;
import wuliu.dto.TransferRequestDto;
import wuliu.dto.TransferTaskDto;
import wuliu.entity.OutStoreTask;
import wuliu.entity.SendTraTask;
import wuliu.entity.TransferTask;
import wuliu.entity.TransferTool;

public class ExamineOutStoreServlet extends HttpServlet {

	
	private static final long serialVersionUID = 7084431809232783827L;
	private OutStoreRequestDao outStoreRequestDao = new OutStoreRequestDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	
	private TransferRequestDao transferRequestDao = new TransferRequestDaoImpl();
	private OutStoreTaskDao outStoreTaskDao = new OutStoreTaskDaoImpl();
	private TransferTaskDao transferTaskDao = new TransferTaskDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	private SendTraTaskDao sendTraTaskDao = new SendTraTaskDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		List<OutStoreRequestDto> listOutStoreRequestDto = outStoreRequestDao.getOutStoreRequestByState(1, pageNum);
		totalCount = outStoreRequestDao.getOutStoreRequestByStateCount(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listOutStoreRequestDto", listOutStoreRequestDto);
		//request.getRequestDispatcher("/dd/dd_shenhecuku.jsp").forward(request, response);
		request.getRequestDispatcher("/kc/dd_shenhecuku.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String[] idList = request.getParameterValues("chkItem");
		for(int i = 0 ; i < idList.length ; i++){
			OutStoreRequestDto osr = outStoreRequestDao.getgetOutStoreRequestById(Integer.parseInt(idList[i]));
			StoreRefGood srf = storeRefGoodDao.examineOutStoreRequest(osr.getStoreId(),osr.getGoodName(), osr.getGoodQuantity());
			//���ͨ�����޸�״̬
			if(srf != null){
				outStoreRequestDao.updateOutStoreRequestState(osr.getOutStoreRequestId(), 2);
				//��ѯ�����δִ�еĳ�������
				List<OutStoreRequestDto> listOutStoreRequestDto = outStoreRequestDao.getOutStoreRequestByState(2);
				//���ɶ�Ӧ�ĳ�������
				OutStoreTask ost = null;
				for(int j = 0 ; j < listOutStoreRequestDto.size() ; j++){
					ost = new OutStoreTask();
					ost.setOutStoreRequestId(listOutStoreRequestDto.get(j).getOutStoreRequestId());
					ost.setStoreId(listOutStoreRequestDto.get(i).getStoreId());
					ost.setStateId(1);
					outStoreTaskDao.addOutStoreTask(ost);
					//���ó�������״̬Ϊ"��ִ��"
					outStoreRequestDao.updateOutStoreRequestState(listOutStoreRequestDto.get(i).getOutStoreRequestId(), 5);
					//���¿����
					storeRefGoodDao.updateStoreGood(listOutStoreRequestDto.get(i).getStoreId(), listOutStoreRequestDto.get(i).getGoodName(), listOutStoreRequestDto.get(i).getGoodQuantity());
				}
			}else{
				outStoreRequestDao.updateOutStoreRequestState(osr.getOutStoreRequestId(), 3);
			}
		}
		response.sendRedirect("queryoutstorerequest");
	}
}
