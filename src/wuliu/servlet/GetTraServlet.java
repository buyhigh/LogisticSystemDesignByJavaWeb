package wuliu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.TraDao;
import wuliu.dao.impl.TraDaoImpl;
import wuliu.dto.TraDto;

public class GetTraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5850592969361040960L;
	private TraDao traDao = new TraDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		response.setCharacterEncoding("utf-8");
		
		String traIdStr = new String(request.getParameter("traId").getBytes("iso8859-1"),"utf-8");
		if(traIdStr != null && !traIdStr.equals("")){
			int traId = Integer.parseInt(traIdStr);
			TraDto td = traDao.getTraById(traId);
			//构造字符串
			//格式：value:value:value...
			String str = td.getDispUserId() + ":"
						+ td.getDispUserName() + ":"
						+ td.getGoodName() + ":"
						+ td.getGoodQuantity() + ":"
						+ td.getReceName() + ":"
						+ td.getReceProvince() + ":"
						+ td.getReceCity() + ":"
						+ td.getReceStreet();
			PrintWriter out = response.getWriter();
			out.print(str);
		}
	}

}
