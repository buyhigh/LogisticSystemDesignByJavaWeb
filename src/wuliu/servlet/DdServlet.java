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
		
//		//查询已审核未执行的出库请求单
//		List<OutStoreRequestDto> listOutStoreRequestDto = outStoreRequestDao.getOutStoreRequestByState(2);
//		//生成对应的出库任务单
//		OutStoreTask ost = null;
//		for(int i = 0 ; i < listOutStoreRequestDto.size() ; i++){
//			ost = new OutStoreTask();
//			ost.setOutStoreRequestId(listOutStoreRequestDto.get(i).getOutStoreRequestId());
//			ost.setStoreId(listOutStoreRequestDto.get(i).getStoreId());
//			ost.setStateId(1);
//			outStoreTaskDao.addOutStoreTask(ost);
//			//设置出库请求单状态为"已执行"
//			outStoreRequestDao.updateOutStoreRequestState(listOutStoreRequestDto.get(i).getOutStoreRequestId(), 5);
//			//更新库存量
//			storeRefGoodDao.updateStoreGood(listOutStoreRequestDto.get(i).getStoreId(), listOutStoreRequestDto.get(i).getGoodName(), listOutStoreRequestDto.get(i).getGoodQuantity());
//		}
		
		
		//查询已审核未执行的运输请求单
		List<TransferRequestDto> listTransferRequestDto = transferRequestDao.getTransferRequestByState(2);
		//生成对应的运输任务单和派车任务单
		TransferTask tt = null;
		SendTraTask stt = null;
		for(int i = 0 ; i < listTransferRequestDto.size() ; i++){
			//生成运输任务单
			tt = new TransferTask();
			tt.setTransferRequestId(listTransferRequestDto.get(i).getTransferRequestId());
			tt.setTransferToolId(listTransferRequestDto.get(i).getTransferToolId());
			tt.setStateId(1);
			transferTaskDao.addTransferTask(tt);
			//设置运输请求单状态为"已执行"
			transferRequestDao.updateTransferRequestDto(listTransferRequestDto.get(i).getTransferRequestId(), 5);
			
			
			//生成派车任务单
			stt = new SendTraTask();
			stt.setTransferRequestId(listTransferRequestDto.get(i).getTransferRequestId());
			TransferTool transferTool = transferToolDao.getTransferToolById(listTransferRequestDto.get(i).getTransferToolId());
			stt.setTransferPlaceId(transferTool.getTransferPlace());
			stt.setTransferModelId(transferTool.getTransferModel());
			stt.setTransferToolId(transferTool.getTransferId());
			stt.setRequestNum(listTransferRequestDto.get(i).getRequestNum());
			stt.setState(1);
			sendTraTaskDao.addSendTraTask(stt);
			
			//更新运力
			transferToolDao.updateTransferToolQuantity(listTransferRequestDto.get(i).getTransferToolId(),listTransferRequestDto.get(i).getRequestNum());
		}
		
		
		
		//获取"未审核"出库任务单
		List<OutStoreTaskDto> listOutStoreTaskDto = outStoreTaskDao.getOutStoreTaskDtoByState(1,1);
		//获取"未审核"运输任务单
		List<TransferTaskDto> listTransferTaskDto = transferTaskDao.getTransferTaskDtoByState(1,1);
		
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		totalCount = outStoreTaskDao.getOutStoreTaskDtoByStateCount(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		int pageNum2 = 1;//当前页码
		int maxPageNum2 = 1;//总页数
		int totalCount2 = 0;//总的记录数
		
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
