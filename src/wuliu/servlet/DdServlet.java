package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class DdServlet extends HttpServlet {

	private static final long serialVersionUID = 7817315950942786783L;
	private OutStoreRequestDao outStoreRequestDao = new OutStoreRequestDaoImpl();
	private TransferRequestDao transferRequestDao = new TransferRequestDaoImpl();
	private OutStoreTaskDao outStoreTaskDao = new OutStoreTaskDaoImpl();
	private TransferTaskDao transferTaskDao = new TransferTaskDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	private SendTraTaskDao sendTraTaskDao = new SendTraTaskDaoImpl();
	
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		
//		//��ѯ�����δִ�еĳ�������
//		List<OutStoreRequestDto> listOutStoreRequestDto = outStoreRequestDao.getOutStoreRequestByState(2);
//		//���ɶ�Ӧ�ĳ�������
//		OutStoreTask ost = null;
//		for(int i = 0 ; i < listOutStoreRequestDto.size() ; i++){
//			ost = new OutStoreTask();
//			ost.setOutStoreRequestId(listOutStoreRequestDto.get(i).getOutStoreRequestId());
//			ost.setStoreId(listOutStoreRequestDto.get(i).getStoreId());
//			ost.setStateId(1);
//			outStoreTaskDao.addOutStoreTask(ost);
//			//���ó�������״̬Ϊ"��ִ��"
//			outStoreRequestDao.updateOutStoreRequestState(listOutStoreRequestDto.get(i).getOutStoreRequestId(), 5);
//			//���¿����
//			storeRefGoodDao.updateStoreGood(listOutStoreRequestDto.get(i).getStoreId(), listOutStoreRequestDto.get(i).getGoodName(), listOutStoreRequestDto.get(i).getGoodQuantity());
//		}
		
		
		//��ѯ�����δִ�е���������
		List<TransferRequestDto> listTransferRequestDto = transferRequestDao.getTransferRequestByState(2);
		//���ɶ�Ӧ���������񵥺��ɳ�����
		TransferTask tt = null;
		SendTraTask stt = null;
		for(int i = 0 ; i < listTransferRequestDto.size() ; i++){
			//������������
			tt = new TransferTask();
			tt.setTransferRequestId(listTransferRequestDto.get(i).getTransferRequestId());
			tt.setTransferToolId(listTransferRequestDto.get(i).getTransferToolId());
			tt.setStateId(1);
			transferTaskDao.addTransferTask(tt);
			//������������״̬Ϊ"��ִ��"
			transferRequestDao.updateTransferRequestDto(listTransferRequestDto.get(i).getTransferRequestId(), 5);
			
			
			//�����ɳ�����
			stt = new SendTraTask();
			stt.setTransferRequestId(listTransferRequestDto.get(i).getTransferRequestId());
			TransferTool transferTool = transferToolDao.getTransferToolById(listTransferRequestDto.get(i).getTransferToolId());
			stt.setTransferPlaceId(transferTool.getTransferPlace());
			stt.setTransferModelId(transferTool.getTransferModel());
			stt.setTransferToolId(transferTool.getTransferId());
			stt.setRequestNum(listTransferRequestDto.get(i).getRequestNum());
			stt.setState(1);
			sendTraTaskDao.addSendTraTask(stt);
			
			//��������
			transferToolDao.updateTransferToolQuantity(listTransferRequestDto.get(i).getTransferToolId(),listTransferRequestDto.get(i).getRequestNum());
		}
		
		
		
		//��ȡ"δ���"��������
		List<OutStoreTaskDto> listOutStoreTaskDto = outStoreTaskDao.getOutStoreTaskDtoByState(1,1);
		//��ȡ"δ���"��������
		List<TransferTaskDto> listTransferTaskDto = transferTaskDao.getTransferTaskDtoByState(1,1);
		
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		totalCount = outStoreTaskDao.getOutStoreTaskDtoByStateCount(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		int pageNum2 = 1;//��ǰҳ��
		int maxPageNum2 = 1;//��ҳ��
		int totalCount2 = 0;//�ܵļ�¼��
		
		totalCount2 = transferTaskDao.getTransferTaskDtoByStateCount(1);
		if(totalCount2 % 10 == 0){
			maxPageNum2 = totalCount2 / 10;
		}else{
			maxPageNum2 = totalCount2 / 10 + 1;
		}
		
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		
		request.setAttribute("curPage2",pageNum2);
		request.setAttribute("maxPage2", maxPageNum2);
		request.setAttribute("count2", totalCount2);
		
		
		request.setAttribute("listOutStoreTaskDto", listOutStoreTaskDto);
		request.setAttribute("listTransferTaskDto", listTransferTaskDto);
		//request.getRequestDispatcher("/dd/dd_dd.jsp").forward(request, response);
		request.getRequestDispatcher("/kc/dd_dd.jsp").forward(request, response);
	}
}
