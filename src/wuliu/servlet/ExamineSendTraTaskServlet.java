package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.SendTraTaskDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.SendTraTaskDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.SendTraTaskDto;
import wuliu.dto.TransferToolDto;

public class ExamineSendTraTaskServlet extends HttpServlet {

	private static final long serialVersionUID = 7085618448578273146L;
	private SendTraTaskDao sendTraTaskDao = new SendTraTaskDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		List<SendTraTaskDto> listSendTraTaskDto = sendTraTaskDao.getSendTraTaskDtoByState(1, pageNum);
		totalCount = sendTraTaskDao.getSendTraTaskCountByState(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listSendTraTaskDto", listSendTraTaskDto);
		request.getRequestDispatcher("/tra/tra_shenhesendtask.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String[] idList = request.getParameterValues("chkItem");
		SendTraTaskDto sttd = null;
		TransferToolDto ttd = null;
		for(int i = 0 ; i < idList.length ; i++){
			sttd = sendTraTaskDao.getSendTraTaskDtoById(Integer.parseInt(idList[i]));
			ttd = transferToolDao.getTransferToolById(sttd.getTransferToolId());
			if(sttd.getRequestNum() <= ttd.getQuantity()){
				//实际需求数量小于可用数量，审核通过，设置单据状态为"已审核未执行2"
				sendTraTaskDao.updateSendTraTaskState(sttd.getSendTraTaskId(), 2);//修改状态
			}else{
				//实际需求已超出可用数量，审核未通过，设置单据状态为"未满足条件3"
				sendTraTaskDao.updateSendTraTaskState(sttd.getSendTraTaskId(), 3);
			}
		}
		response.sendRedirect("querysendtratask");
		
	}
}
