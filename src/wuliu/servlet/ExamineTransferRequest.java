package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.TransferRequestDao;
import wuliu.dao.impl.TransferRequestDaoImpl;
import wuliu.dto.TransferRequestDto;
import wuliu.entity.SendTraTask;
import wuliu.entity.TransferTask;
import wuliu.entity.TransferTool;

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

public class ExamineTransferRequest extends HttpServlet{

	
	private static final long serialVersionUID = -5634376372146659848L;
	private TransferRequestDao transferRequestDao = new TransferRequestDaoImpl();
	private OutStoreRequestDao outStoreRequestDao = new OutStoreRequestDaoImpl();
	private OutStoreTaskDao outStoreTaskDao = new OutStoreTaskDaoImpl();
	private TransferTaskDao transferTaskDao = new TransferTaskDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	private SendTraTaskDao sendTraTaskDao = new SendTraTaskDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		List<TransferRequestDto> listTransferRequestDto = transferRequestDao.getTransferRequestByState(1, pageNum);
		totalCount = transferRequestDao.getTransferRequestByStateCount(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listTransferRequestDto", listTransferRequestDto);
		//request.getRequestDispatcher("/dd/dd_shenheyunsu.jsp").forward(request, response);
		request.getRequestDispatcher("/kc/dd_shenheyunsu.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String[] idList = request.getParameterValues("chkItem");
		TransferRequestDto transferRequestDto = null;
		for(int i = 0 ; i < idList.length ; i++){
			transferRequestDto = transferRequestDao.getTransferRequestById(Integer.parseInt(idList[i]));
			//运力满足，审核通过，修改单据状态为"已审核未执行"
			if(transferRequestDto.getRequestNum() <= transferRequestDto.getTransferQuantity()){
				transferRequestDao.updateTransferRequestDto(Integer.parseInt(idList[i]), 2);
				//查询已审核未执行的运输请求单
				List<TransferRequestDto> listTransferRequestDto = transferRequestDao.getTransferRequestByState(2);
				//生成对应的运输任务单和派车任务单
				TransferTask tt = null;
				SendTraTask stt = null;
				for(int j = 0 ; j < listTransferRequestDto.size() ; j++){
					//生成运输任务单
					tt = new TransferTask();
					tt.setTransferRequestId(listTransferRequestDto.get(j).getTransferRequestId());
					tt.setTransferToolId(listTransferRequestDto.get(j).getTransferToolId());
					tt.setStateId(1);
					transferTaskDao.addTransferTask(tt);
					//设置运输请求单状态为"已执行"
					transferRequestDao.updateTransferRequestDto(listTransferRequestDto.get(j).getTransferRequestId(), 5);
					
					
					//生成派车任务单
					stt = new SendTraTask();
					stt.setTransferRequestId(listTransferRequestDto.get(j).getTransferRequestId());
					TransferTool transferTool = transferToolDao.getTransferToolById(listTransferRequestDto.get(j).getTransferToolId());
					stt.setTransferPlaceId(transferTool.getTransferPlace());
					stt.setTransferModelId(transferTool.getTransferModel());
					stt.setTransferToolId(transferTool.getTransferId());
					stt.setRequestNum(listTransferRequestDto.get(j).getRequestNum());
					stt.setState(1);
					sendTraTaskDao.addSendTraTask(stt);
					
					//更新运力
					transferToolDao.updateTransferToolQuantity(listTransferRequestDto.get(j).getTransferToolId(),listTransferRequestDto.get(j).getRequestNum());
				}
			}else{
				//运力不满足，审核未通过，修改单据状态为"未满足条件"
				transferRequestDao.updateTransferRequestDto(Integer.parseInt(idList[i]), 3);
			}
		}
		response.sendRedirect("querytra");
		
	}
}
