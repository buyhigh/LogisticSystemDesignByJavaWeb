package wuliu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityFilter implements Filter {
	private FilterConfig config;
	//初始化方法
	public void init(FilterConfig config){
		this.config = config;
	}
	//实现销毁方法
	public void destroy(){
		this.config = null;
	}
	//执行过滤的核心方法
	public void doFilter(ServletRequest requ,ServletResponse resp,FilterChain chain)
	throws IOException,ServletException{
		//将请求转换成HttpServletRequest、HttpServletResponse请求
		HttpServletRequest request = (HttpServletRequest)requ;
		HttpServletResponse response = (HttpServletResponse)resp;
		//设置request编码用的字符集
		request.setCharacterEncoding("gbk");
		//获取客户请求的页面
		String requestPath = request.getServletPath();
		if(requestPath.endsWith(".jsp")){
			//如果请求jsp页面时系统forward跳转到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			//如果不是，执行“放行请求”
			chain.doFilter(request, response);
		}
	}
}
