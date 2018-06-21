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
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		//点击查询按钮时获取当前选中的状态  
		String curStateStr = request.getParameter("selLibrary");
		int curState = -1;
		if(curStateStr != null && !curStateStr.equals("")){
			curState = Integer.parseInt(curStateStr);
		}
		
		//点击超链接时获取页码信息及当前选中的状态
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
			String curSelState = request.getParameter("curState");
			if(curSelState != null && !curSelState.equals("")){
				curState = Integer.parseInt(curSelState);
			}
		}
		
		//分页
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
