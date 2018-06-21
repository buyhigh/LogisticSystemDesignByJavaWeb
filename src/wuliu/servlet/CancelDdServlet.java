package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.DispatchDao;
import wuliu.dao.OutStoreRequestDao;
import wuliu.dao.TransferRequestDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.OutStoreRequestDaoImpl;
import wuliu.dao.impl.TransferRequestDaoImpl;
import wuliu.dto.OutStoreRequestDto;
import wuliu.dto.TransferRequestDto;

public class CancelDdServlet extends HttpServlet {

	
	private static final long serialVersionUID = 3876611545612019092L;
	private OutStoreRequestDao outStoreRequestDao = new OutStoreRequestDaoImpl();
	private TransferRequestDao transferRequestDao = new TransferRequestDaoImpl();
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		List<OutStoreRequestDto> listOutStoreRequestDto = outStoreRequestDao.getOutStoreRequestByState(2);
		List<TransferRequestDto> listTransferRequestDto = transferRequestDao.getTransferRequestByState(2);
		
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		totalCount = outStoreRequestDao.getOutStoreRequestByStateCount(2);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		int pageNum2 = 1;//当前页码
		int maxPageNum2 = 1;//总页数
		int totalCount2 = 0;//总的记录数
		String pageNumStr2 = request.getParameter("pageNum2");
		if(pageNumStr2 != null && !pageNumStr2.equals("")){
			pageNum2 = Integer.parseInt(pageNumStr2);
		}
		
		totalCount2 = transferRequestDao.getTransferRequestByStateCount(2);
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
		
		request.setAttribute("listOutStoreRequestDto", listOutStoreRequestDto);
		request.setAttribute("listTransferRequestDto", listTransferRequestDto);
		//request.getRequestDispatcher("/dd/dd_quxiaodd.jsp").forward(request, response);
		request.getRequestDispatcher("/kc/dd_quxiaodd.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String flag = request.getParameter("flag");
		if(flag.equals("1")){
			//取消调度出库请求单
			
			//获取需要取消调度的出库请求单ID
			String[] idList1 = request.getParameterValues("chkItem");
			for(int i = 0 ; i < idList1.length ; i++){
				int outstorerequest = Integer.parseInt(idList1[i]);
				OutStoreRequestDto osr = outStoreRequestDao.getgetOutStoreRequestById(outstorerequest);
				int dispatch = osr.getDispatchId();
				outStoreRequestDao.updateOutStoreRequestState(outstorerequest, 4);
				dispatchDao.updateDispatchState(dispatch, 4);
			}
		}else if(flag.equals("2")){
			//取消调度运输请求单
			
			//获取需要取消调度的运输请求单ID
			String[] idList2 = request.getParameterValues("chkItem2");
			for(int i = 0 ; i < idList2.length ; i++){
				int transferrequest = Integer.parseInt(idList2[i]);
				TransferRequestDto trd = transferRequestDao.getTransferRequestById(transferrequest);
				int dispatch = trd.getDispatchId();
				transferRequestDao.updateTransferRequestDto(transferrequest, 4);
				dispatchDao.updateDispatchState(dispatch, 4);
			}
		}
		response.sendRedirect("canceldd");
		
		
		
	}
	
}
