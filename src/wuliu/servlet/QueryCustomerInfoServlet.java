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


public class QueryCustomerInfoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private StateDao stateDao = new StateDaoImpl();//��©�����������ӽ�����ӿڣ�ʵ���������ʵ�ַ����ϵ�
	private UserDao userDao = new UserDaoImpl();//��©�����������ӽ�����ӿڣ�ʵ���������ʵ�ַ����ϵ�
	

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		//List<State> listState = stateDao.getAllState();
		List<User> listUser = userDao.getUserByType(1);
		request.setAttribute("listUser", listUser);
		for(int j=0;j<listUser.size();j++){
            System.out.println("ÿ��ʵ�����ֵΪ"+listUser.get(j).getUserId());
            System.out.println("ÿ��ʵ�����ֵΪ"+listUser.get(j).getUserName());
            System.out.println("ÿ��ʵ�����ֵΪ"+listUser.get(j).getUserType());
        }
		
		request.getRequestDispatcher("/gh/gh_chaxunkehuxinxi.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		request.getRequestDispatcher("/gh/gh_chaxunkehuxinxi.jsp").forward(request, response);
	}

}
