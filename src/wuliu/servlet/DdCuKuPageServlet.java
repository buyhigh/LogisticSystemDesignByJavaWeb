package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.OutStoreTaskDao;
import wuliu.dao.TransferTaskDao;
import wuliu.dao.impl.OutStoreTaskDaoImpl;
import wuliu.dao.impl.TransferTaskDaoImpl;
import wuliu.dto.OutStoreTaskDto;
import wuliu.dto.TransferTaskDto;

public class DdCuKuPageServlet extends HttpServlet {

	private static final long serialVersionUID = -2914473077962508740L;
	private OutStoreTaskDao outStoreTaskDao = new OutStoreTaskDaoImpl();
	private TransferTaskDao transferTaskDao = new TransferTaskDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		
		List<OutStoreTaskDto> listOutStoreRequestDto = outStoreTaskDao.getOutStoreTaskDtoByState(1,pageNum);
		totalCount = outStoreTaskDao.getOutStoreTaskDtoByStateCount(1);
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
		
		
		List<TransferTaskDto> listTransferTaskDto = transferTaskDao.getTransferTaskDtoByState(1, pageNum2);
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
		request.setAttribute("listOutStoreRequestDto", listOutStoreRequestDto);
		request.setAttribute("listTransferTaskDto", listTransferTaskDto);
		//request.getRequestDispatcher("/dd/dd_dd.jsp").forward(request, response);
		request.getRequestDispatcher("/kc/dd_dd.jsp").forward(request, response);
	}
}
