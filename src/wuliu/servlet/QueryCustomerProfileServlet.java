package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.dao.ProfileDao;
import wuliu.dao.UserDao;
import wuliu.dao.impl.ProfileDaoImpl;
import wuliu.dao.impl.UserDaoImpl;
import wuliu.entity.Profile;
import wuliu.entity.User;

public class QueryCustomerProfileServlet extends HttpServlet {
	
	private ProfileDao profileDao = new ProfileDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		HttpSession session = request.getSession();
		String loginUser =((User) session.getAttribute("loginUser")).getUserName();
		System.out.println(loginUser);
		Profile profile = profileDao.getProfileByName(loginUser);
		request.setAttribute("profile", profile);
		System.out.println(profile.getRealName());
		request.getRequestDispatcher("/kh/kh_gerenxinxi.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		request.getRequestDispatcher("/kh/kh_gerenxinxi.jsp").forward(request, response);
	}

}
