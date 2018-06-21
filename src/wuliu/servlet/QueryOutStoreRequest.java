package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.OutStoreRequestDao;
import wuliu.dao.StateDao;
import wuliu.dao.impl.OutStoreRequestDaoImpl;
import wuliu.dao.impl.StateDaoImpl;
import wuliu.dto.OutStoreRequestDto;
import wuliu.entity.State;

public class QueryOutStoreRequest extends HttpServlet {

	private static final long serialVersionUID = -2428144270838097735L;
	private StateDao stateDao = new StateDaoImpl();
	private OutStoreRequestDao outStoreRequestDao = new OutStoreRequestDaoImpl();
	
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
		List<OutStoreRequestDto> listOutStoreRequestDto = null;
		if(curState != -1){
			listOutStoreRequestDto = outStoreRequestDao.getOutStoreRequestByState(curState,pageNum);
			totalCount = outStoreRequestDao.getOutStoreRequestByStateCount(curState);
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
		request.setAttribute("listOutStoreRequestDto", listOutStoreRequestDto);
		request.setAttribute("curState", curState);
		request.setAttribute("listState", listState);
		//request.getRequestDispatcher("/dd/dd_chaxuncukudan.jsp").forward(request,response);
		request.getRequestDispatcher("/kc/dd_chaxuncukudan.jsp").forward(request,response);
	}
	
}
