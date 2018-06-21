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


public class AddTransporterServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	//private StateDao stateDao = new StateDaoImpl();//��©�����������ӽ�����ӿڣ�ʵ���������ʵ�ַ����ϵ�
	private UserDao userDao = new UserDaoImpl();//��©�����������ӽ�����ӿڣ�ʵ���������ʵ�ַ����ϵ�
	

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		request.getRequestDispatcher("/gh/gh_zengjiayundiaoyuan.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String regtransporterId = request.getParameter("regtransporterId");
		String regtransporterpwd = request.getParameter("regtransporterpwd");
		userDao.addUser(regtransporterId,regtransporterpwd,7);
		response.sendRedirect("QueryStaffInfo");
	}
}
