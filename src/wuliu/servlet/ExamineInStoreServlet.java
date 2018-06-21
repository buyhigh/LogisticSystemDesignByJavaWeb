package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.InStoreRequestDao;
import wuliu.dao.impl.InStoreRequestDaoImpl;
import wuliu.dto.InStoreRequestDto;

public class ExamineInStoreServlet extends HttpServlet {

	private static final long serialVersionUID = 687453141570362108L;
	private InStoreRequestDao inStoreRequestDao = new InStoreRequestDaoImpl();
	
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		List<InStoreRequestDto> listInStoreRequestDto = inStoreRequestDao.getInStoreRequestByState(1, pageNum);
		totalCount = inStoreRequestDao.getInStoreRequestByStateCount(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listInStoreRequestDto", listInStoreRequestDto);
		request.getRequestDispatcher("/kc/kc_shenherukudan.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
			
		//��ȡ�Ѿ�ͨ����˵��������id�б�
		String[] idList = request.getParameterValues("chkItem");
		
		//�ı�״̬Ϊ"�����δִ��---2"
		inStoreRequestDao.updateInStoreRequestState(idList, 2);
		
		response.sendRedirect("queryinstoretask");
		
	}
	
}
