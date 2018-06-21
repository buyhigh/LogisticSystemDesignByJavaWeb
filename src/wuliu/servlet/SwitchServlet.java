package wuliu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.entity.User;

public class SwitchServlet extends HttpServlet {

	private static final long serialVersionUID = 8762955309187783205L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null){
			request.setAttribute("message", "请登录");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			int userType = ((User)session.getAttribute("loginUser")).getUserType();
			int sysItem = Integer.parseInt(request.getParameter("msg"));
			switch(sysItem){
			case 1:
				//进入接单系统
				if(userType == 1 || userType == 2 || userType == 8){
					request.getRequestDispatcher("/jd/querydispatch").forward(request, response);
				}else{
					request.setAttribute("privilegeMsg", "对不起，您没有权限进入本系统！");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				break;
			case 2:
				//进入调度系统
				if(userType == 3 || userType == 8){
					//request.getRequestDispatcher("/dd/queryoutstorerequest").forward(request, response);
					request.getRequestDispatcher("/kc/queryoutstorerequest").forward(request, response);
				}else{
					request.setAttribute("privilegeMsg", "对不起，您没有权限进入本系统！");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				break;
			case 3:
				//进入库存系统
				if(userType == 4 || userType == 5 || userType == 6 || userType == 8){
					request.getRequestDispatcher("/kc/kc_execchuku.jsp").forward(request, response);
				}else{
					request.setAttribute("privilegeMsg", "对不起，您没有权限进入本系统！");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				break;
			case 4:
				if(userType == 7 || userType == 8){
					request.getRequestDispatcher("/tra/queryyl2").forward(request, response);
				}else{
					request.setAttribute("privilegeMsg", "对不起，您没有权限进入本系统！");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				break;
			case 5:
				if(userType == 1 || userType == 2 || userType == 8) {
					request.getRequestDispatcher("/kh/QueryDispatch1").forward(request, response);
				}else{
					request.setAttribute("privilegeMsg", "对不起，您没有权限进入本系统！");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				break;
			case 6:
				if(userType == 8) {
					request.getRequestDispatcher("/gh/QueryCustomerInfo").forward(request, response);
				}else{
					request.setAttribute("privilegeMsg", "对不起，您没有权限进入本系统！");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				break;
			case 7:
				request.getRequestDispatcher("/test").forward(request, response);
				break;
			}
			
		}
	}

}
