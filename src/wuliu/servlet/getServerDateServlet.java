package wuliu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getServerDateServlet extends HttpServlet {

	private static final long serialVersionUID = 5044064818139684879L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		response.setCharacterEncoding("utf-8");
		String str = "��ǰʱ�䣺";
		String[] weekDays = {"","������","����һ","���ڶ�","������","������","������","������"};
		Calendar c = Calendar.getInstance();
		str += c.get(Calendar.YEAR) + "��";
		str += c.get(Calendar.MONTH) +1+ "��";
		str += c.get(Calendar.DATE) + "��  ";
		str += c.get(Calendar.HOUR_OF_DAY) + "ʱ";
		str += c.get(Calendar.MINUTE) + "��";
		str += c.get(Calendar.SECOND) + "��  ";
		str += weekDays[c.get(Calendar.DAY_OF_WEEK)];
		
		PrintWriter out = response.getWriter();
		out.print(str);
	}

}
