package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.InStoreRequestDao;
import wuliu.dao.StateDao;
import wuliu.dao.impl.InStoreRequestDaoImpl;
import wuliu.dao.impl.StateDaoImpl;
import wuliu.dto.InStoreRequestDto;
import wuliu.entity.State;

public class QueryInStoreTaskServlet extends HttpServlet {

	private static final long serialVersionUID = -6097071233110597417L;
	
	private StateDao stateDao = new StateDaoImpl();
	private InStoreRequestDao inStoreRequestDao = new InStoreRequestDaoImpl();
	
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
		
		//��ҳ
		List<InStoreRequestDto> listInStoreRequestDto = null;
		if(curState != -1){
			listInStoreRequestDto = inStoreRequestDao.getInStoreRequestByState(curState,pageNum);
			totalCount = inStoreRequestDao.getInStoreRequestByStateCount(curState);
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
		request.setAttribute("listInStoreRequestDto", listInStoreRequestDto);
		request.setAttribute("curState", curState);
		request.setAttribute("listState", listState);
		request.getRequestDispatcher("/kc/kc_queryrukudan.jsp").forward(request,response);
	}
}
