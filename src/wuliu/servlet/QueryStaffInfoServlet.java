package wuliu.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import wuliu.entity.State;
import wuliu.entity.User;
import wuliu.dao.UserDao;
import wuliu.dao.impl.UserDaoImpl;
import wuliu.dao.StateDao;
import wuliu.dao.impl.StateDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class QueryStaffInfoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private StateDao stateDao = new StateDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	private UserDao userDao = new UserDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		//List<State> listState = stateDao.getAllState();
		List<User> listMarketer = userDao.getUserByType(2);
		List<User> listStorer = userDao.getUserByType(4);
		List<User> listTransporter = userDao.getUserByType(7);
		request.setAttribute("listMarketer", listMarketer);
		request.setAttribute("listStorer", listStorer);
		request.setAttribute("listTransporter", listTransporter);
		
		request.getRequestDispatcher("/gh/gh_chaxungongzuorenyuan.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		request.getRequestDispatcher("/gh/gh_chaxunkehuxinxi.jsp").forward(request, response);
	}

}
