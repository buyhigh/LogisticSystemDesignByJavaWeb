package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.dao.FinConfirmDao;
import wuliu.dao.impl.FinConfirmDaoImpl;
import wuliu.entity.FinConfirm;

import wuliu.entity.User;

public class QueryFinConfirmServlet extends HttpServlet {
	
	private FinConfirmDao finconfirmDao = new FinConfirmDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		HttpSession session = request.getSession();
		String loginUser =((User) session.getAttribute("loginUser")).getUserName();
		List<FinConfirm> listfinconfirm = finconfirmDao.getFinConfirmByConsumerState2(loginUser);
		System.out.println(loginUser);
		//运送状态待确认是1，确认是2
		request.setAttribute("listfinconfirm", listfinconfirm);
		request.getRequestDispatcher("/kh/kh_chaxunyijingwanchengdedingdan.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		HttpSession session = request.getSession();
		String loginUser =((User) session.getAttribute("loginUser")).getUserName();
		List<FinConfirm> listfinconfirm = finconfirmDao.getFinConfirmByConsumerState2(loginUser);
		System.out.println(loginUser);
		//运送状态待确认是1，确认是2
		request.setAttribute("listfinconfirm", listfinconfirm);

		request.getRequestDispatcher("/kh/kh_chaxunyijingwanchengdedingdan.jsp").forward(request, response);
	}

}
