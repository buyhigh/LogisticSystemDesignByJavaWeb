package wuliu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.dao.UserDao;
import wuliu.dao.impl.UserDaoImpl;
import wuliu.entity.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2724805758159769000L;
	private UserDao userDao = new UserDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		HttpSession session = request.getSession();
		User user = userDao.getUserByName(userName);
		if(user != null && user.getUserPass().equals(userPass)){
			session.setAttribute("loginUser", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("message","用户名或密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
