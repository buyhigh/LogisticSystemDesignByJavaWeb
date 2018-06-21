package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.SendTraTaskDao;
import wuliu.dao.StateDao;
import wuliu.dao.impl.SendTraTaskDaoImpl;
import wuliu.dao.impl.StateDaoImpl;
import wuliu.dto.SendTraTaskDto;
import wuliu.entity.State;

public class QuerySendTraTaskServlet extends HttpServlet {

	private static final long serialVersionUID = -1280147330829052836L;
	private SendTraTaskDao sendTraTaskDao = new SendTraTaskDaoImpl();
	private StateDao stateDao = new StateDaoImpl();
	
	
	protected void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		//�����ѯ��ťʱ��ȡ��ǰѡ�е�״̬  
		String curStateStr = request.getParameter("selLibrary");
		int curState = -1;
		if(curStateStr != null && !curStateStr.equals("")){
			curState = Integer.parseInt(curStateStr);
		}
		
		//���������ʱ��ȡҳ����Ϣ����ǰѡ�е�״̬
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
			String curSelState = request.getParameter("curState");
			if(curSelState != null && !curSelState.equals("")){
				curState = Integer.parseInt(curSelState);
			}
		}
		
		List<SendTraTaskDto> listSendTraTaskDto = null;
		if(curState != -1){
			listSendTraTaskDto = sendTraTaskDao.getSendTraTaskDtoByState(curState, pageNum);
			totalCount = sendTraTaskDao.getSendTraTaskCountByState(curState);
			if(totalCount % 10 == 0){
				maxPageNum = totalCount / 10;
			}else{
				maxPageNum = totalCount / 10 + 1;
			}
		}
		
		List<State> listState = stateDao.getAllState();
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listSendTraTaskDto", listSendTraTaskDto);
		request.setAttribute("curState", curState);
		request.setAttribute("listState", listState);
		
		request.getRequestDispatcher("/tra/tra_querysendtask.jsp").forward(request, response);
	}

}
