package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.dao.DispatchDao;
import wuliu.dao.StateDao;
import wuliu.dao.UserDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.StateDaoImpl;
import wuliu.dto.DispatchDto;
import wuliu.entity.State;
import wuliu.entity.User;

public class QueryDispatchServlet1 extends HttpServlet {

	private static final long serialVersionUID = 8044555164802872512L;
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	private StateDao stateDao = new StateDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		int pageNum = 1;//��ǰҳ��
		int maxPage = 1;//���ҳ��
		int rowCount = 0;
		HttpSession session = request.getSession();
		int logintype = ((User) session.getAttribute("loginUser")).getUserType();
		String loginUser =((User) session.getAttribute("loginUser")).getUserName();
		System.out.println(loginUser);
		if (logintype == 1) {
			System.out.println("��¼�����ǿͻ�");
			//int userType = ((User)session.getAttribute("loginUser")).getUserType();
			//System.out.println("userType" + userType);
			
			String curStateStr = request.getParameter("curState");
			int curState = -1;
			if(curStateStr != null && !curStateStr.equals("")){
				curState = Integer.parseInt(curStateStr);
			}
			String pageNumStr = request.getParameter("pageNum");
			if(pageNumStr != null && !pageNumStr.equals("")){
				pageNum = Integer.parseInt(pageNumStr);
			}
			
			State curStateObj = stateDao.getStateById(curState);
			List<DispatchDto> listDispatchDto = null;
			if(curStateObj == null){
				rowCount = dispatchDao.getDispatchCount(loginUser);
				listDispatchDto = dispatchDao.getAllDispatch(loginUser,pageNum);
			}else{
				rowCount = dispatchDao.getDispatchCount(loginUser,curState);
				listDispatchDto = dispatchDao.getDispatchByState(loginUser,curState, pageNum);
			}
			
			if(rowCount % 10 == 0){
				maxPage = rowCount / 10;
			}else{
				maxPage = rowCount / 10 + 1;
			}
			
			List<State> listState = stateDao.getAllState();
			
			request.setAttribute("curState", curStateObj);
			request.setAttribute("curPage", pageNum);
			request.setAttribute("maxPage",maxPage);
			request.setAttribute("rowCount", rowCount);
			request.setAttribute("listState", listState);
			request.setAttribute("listDispatchDto", listDispatchDto);
			request.getRequestDispatcher("/kh/kh_chaxundingdanzhuangtai.jsp").forward(request, response);
		}
		
		
		else if (logintype == 8) {
			System.out.println("��½�����ǹ���Ա");
			//int userType = ((User)session.getAttribute("loginUser")).getUserType();
			//System.out.println("userType" + userType);
			
			String curStateStr = request.getParameter("curState");
			int curState = -1;
			if(curStateStr != null && !curStateStr.equals("")){
				curState = Integer.parseInt(curStateStr);
			}
			String pageNumStr = request.getParameter("pageNum");
			if(pageNumStr != null && !pageNumStr.equals("")){
				pageNum = Integer.parseInt(pageNumStr);
			}
			
			State curStateObj = stateDao.getStateById(curState);
			List<DispatchDto> listDispatchDto = null;
			if(curStateObj == null){
				rowCount = dispatchDao.getDispatchCount();
				listDispatchDto = dispatchDao.getAllDispatch(pageNum);
			}else{
				rowCount = dispatchDao.getDispatchCount(curState);
				listDispatchDto = dispatchDao.getDispatchByState(curState, pageNum);
			}
			
			if(rowCount % 10 == 0){
				maxPage = rowCount / 10;
			}else{
				maxPage = rowCount / 10 + 1;
			}
			
			List<State> listState = stateDao.getAllState();
			
			request.setAttribute("curState", curStateObj);
			request.setAttribute("curPage", pageNum);
			request.setAttribute("maxPage",maxPage);
			request.setAttribute("rowCount", rowCount);
			request.setAttribute("listState", listState);
			request.setAttribute("listDispatchDto", listDispatchDto);
			request.getRequestDispatcher("/kh/kh_chaxundingdanzhuangtai.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String operateStr = request.getParameter("operate");//��ʶ��������	1����ѯ	2��ɾ��
		String stateStr = request.getParameter("stateList");//��ǰѡ�е�״̬
		int operate = -1;
		int state = -1;
		HttpSession session = request.getSession();
		int logintype = ((User) session.getAttribute("loginUser")).getUserType();
		String loginUser =((User) session.getAttribute("loginUser")).getUserName();
		if (logintype == 1) {
			System.out.println("��¼�����ǿͻ�");
			if(operateStr != null && !operateStr.equals("")){
				operate = Integer.parseInt(operateStr);
			}
			if(stateStr != null && !stateStr.equals("")){
				state = Integer.parseInt(stateStr);
			}
			State curState = stateDao.getStateById(state);//��ȡ��ǰѡ���State
			List<State> listState = stateDao.getAllState();//��ȡ���е�State
			List<DispatchDto> listDispatchDto = null;
			switch(operate){
			case 1:
				//��ѯ����
				int pageNum = 1;//��ǰҳ��
				int maxPage = 1;//���ҳ��
				int rowCount = dispatchDao.getDispatchCount(loginUser,state);//�ܵļ�¼��
				if(rowCount % 10 == 0){
					maxPage = rowCount / 10;
				}else{
					maxPage = rowCount / 10 + 1;
				}
				listDispatchDto = dispatchDao.getDispatchByState(loginUser,state,pageNum);
				request.setAttribute("curPage", pageNum);
				request.setAttribute("maxPage",maxPage);
				request.setAttribute("rowCount", rowCount);
				break;
			case 2:
				//ɾ������
				String[] dispatchIdList = request.getParameterValues("chkItem");
				dispatchDao.deleteDispatchByIdList(dispatchIdList);
				String curStateStr = request.getParameter("curState");
				if(curStateStr != null){
					if(curStateStr.equals("")){
						listDispatchDto = dispatchDao.getAllDispatch(loginUser);
					}else{
						listDispatchDto = dispatchDao.getDispatchByState(loginUser,Integer.parseInt(curStateStr));
					}
				}
				break;
			}
			request.setAttribute("listDispatchDto",listDispatchDto);
			request.setAttribute("curState",curState);
			request.setAttribute("listState", listState);
			request.getRequestDispatcher("/kh/kh_chaxundingdanzhuangtai.jsp").forward(request, response);
		}
		else if (logintype == 8) {
			System.out.println("��¼�����ǹ���Ա");
			if(operateStr != null && !operateStr.equals("")){
				operate = Integer.parseInt(operateStr);
			}
			if(stateStr != null && !stateStr.equals("")){
				state = Integer.parseInt(stateStr);
			}
			State curState = stateDao.getStateById(state);//��ȡ��ǰѡ���State
			List<State> listState = stateDao.getAllState();//��ȡ���е�State
			List<DispatchDto> listDispatchDto = null;
			switch(operate){
			case 1:
				//��ѯ����
				int pageNum = 1;//��ǰҳ��
				int maxPage = 1;//���ҳ��
				int rowCount = dispatchDao.getDispatchCount(state);//�ܵļ�¼��
				if(rowCount % 10 == 0){
					maxPage = rowCount / 10;
				}else{
					maxPage = rowCount / 10 + 1;
				}
				listDispatchDto = dispatchDao.getDispatchByState(state,pageNum);
				request.setAttribute("curPage", pageNum);
				request.setAttribute("maxPage",maxPage);
				request.setAttribute("rowCount", rowCount);
				break;
			case 2:
				//ɾ������
				String[] dispatchIdList = request.getParameterValues("chkItem");
				dispatchDao.deleteDispatchByIdList(dispatchIdList);
				String curStateStr = request.getParameter("curState");
				if(curStateStr != null){
					if(curStateStr.equals("")){
						listDispatchDto = dispatchDao.getAllDispatch();
					}else{
						listDispatchDto = dispatchDao.getDispatchByState(Integer.parseInt(curStateStr));
					}
				}
				break;
			}
			request.setAttribute("listDispatchDto",listDispatchDto);
			request.setAttribute("curState",curState);
			request.setAttribute("listState", listState);
			request.getRequestDispatcher("/kh/kh_chaxundingdanzhuangtai.jsp").forward(request, response);
		}
	}

}
