package wuliu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import wuliu.entity.Dispatch;
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


public class DelUserServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	//private StateDao stateDao = new StateDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	private UserDao userDao = new UserDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		List<User> listMarketer = userDao.getUserByType(2);
		List<User> listStorer = userDao.getUserByType(4);
		List<User> listTransporter = userDao.getUserByType(7);
		List<User> listCustomer = userDao.getUserByType(1);
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listMarketer", listMarketer);
		request.setAttribute("listStorer", listStorer);
		request.setAttribute("listTransporter", listTransporter);
		request.getRequestDispatcher("/gh/gh_shanchuzhanghuxinxi.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String deluserId = request.getParameter("deluserId");
		userDao.delUser(Integer.parseInt(deluserId));
		List<User> listMarketer = userDao.getUserByType(2);
		List<User> listStorer = userDao.getUserByType(4);
		List<User> listTransporter = userDao.getUserByType(7);
		List<User> listCustomer = userDao.getUserByType(1);
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listMarketer", listMarketer);
		request.setAttribute("listStorer", listStorer);
		request.setAttribute("listTransporter", listTransporter);
		request.getRequestDispatcher("/gh/gh_shanchuzhanghuxinxi.jsp").forward(request, response);
	}

}
