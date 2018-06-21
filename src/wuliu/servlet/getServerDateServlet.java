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
		String str = "当前时间：";
		String[] weekDays = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar c = Calendar.getInstance();
		str += c.get(Calendar.YEAR) + "年";
		str += c.get(Calendar.MONTH) +1+ "月";
		str += c.get(Calendar.DATE) + "日  ";
		str += c.get(Calendar.HOUR_OF_DAY) + "时";
		str += c.get(Calendar.MINUTE) + "分";
		str += c.get(Calendar.SECOND) + "秒  ";
		str += weekDays[c.get(Calendar.DAY_OF_WEEK)];
		
		PrintWriter out = response.getWriter();
		out.print(str);
	}

}
