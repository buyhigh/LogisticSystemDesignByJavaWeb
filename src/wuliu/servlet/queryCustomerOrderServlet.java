package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class queryCustomerOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		request.getRequestDispatcher("/kh/kh_chaxundingdanzhuangtai.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		request.getRequestDispatcher("/kh/kh_chaxundingdanzhuangtai.jsp").forward(request, response);
	}

}
