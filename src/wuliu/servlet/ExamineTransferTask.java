package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.TransferTaskDao;
import wuliu.dao.impl.TransferTaskDaoImpl;
import wuliu.dto.TransferTaskDto;

public class ExamineTransferTask extends HttpServlet {

	private static final long serialVersionUID = 7195669444075090829L;
	private TransferTaskDao transferTaskDao = new TransferTaskDaoImpl();
	
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		List<TransferTaskDto> listTransferTaskDto = transferTaskDao.getTransferTaskDtoByState(1, pageNum);
		totalCount = transferTaskDao.getTransferTaskDtoByStateCount(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listTransferTaskDto", listTransferTaskDto);
		request.getRequestDispatcher("/tra/tra_shenheyunsu.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String[] idList = request.getParameterValues("chkItem");
		TransferTaskDto transferTaskDto = null;
		for(int i = 0 ; i < idList.length ; i++){
			transferTaskDto = transferTaskDao.getTransferTaskDtoById(Integer.parseInt(idList[i]));
			if(transferTaskDto.getRequestNum() <= transferTaskDto.getTransferQuantity()){
				//��������С��ʵ���������ߵ����������ͨ��,�ı䵥��״̬Ϊ"�����δִ��"
				transferTaskDao.updateTransferTaskState(transferTaskDto.getTransferTaskId(),2);//��״̬�ı�
			}else{
				//������������ʵ�ʶ������ߵ����������δͨ��,�ı䵥��״̬Ϊ"δ��������"
				transferTaskDao.updateTransferTaskState(transferTaskDto.getTransferTaskId(), 3);
			}
			response.sendRedirect("querytratask");
		}
	}

}
