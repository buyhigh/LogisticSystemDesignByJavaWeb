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

import wuliu.entity.Profile;
import wuliu.dao.ProfileDao;
import wuliu.dao.impl.ProfileDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddConsumerServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private UserDao userDao = new UserDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	private ProfileDao profileDao = new ProfileDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		request.getRequestDispatcher("/ConsumerReg.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String regconsumerId = request.getParameter("regconsumerId");
		String regconsumerpwd = request.getParameter("regconsumerpwd");
		String regrealname = request.getParameter("regrealname");
		String regtelphone = request.getParameter("regtelphone");
		String regaddress = request.getParameter("regaddress");
		userDao.addUser(regconsumerId,regconsumerpwd,1);
		profileDao.addProfile(regconsumerId,regrealname,regtelphone,regaddress);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
