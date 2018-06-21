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
	//��ʼ������
	public void init(FilterConfig config){
		this.config = config;
	}
	//ʵ�����ٷ���
	public void destroy(){
		this.config = null;
	}
	//ִ�й��˵ĺ��ķ���
	public void doFilter(ServletRequest requ,ServletResponse resp,FilterChain chain)
	throws IOException,ServletException{
		//������ת����HttpServletRequest��HttpServletResponse����
		HttpServletRequest request = (HttpServletRequest)requ;
		HttpServletResponse response = (HttpServletResponse)resp;
		//����request�����õ��ַ���
		request.setCharacterEncoding("gbk");
		//��ȡ�ͻ������ҳ��
		String requestPath = request.getServletPath();
		if(requestPath.endsWith(".jsp")){
			//�������jspҳ��ʱϵͳforward��ת����¼ҳ��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			//������ǣ�ִ�С���������
			chain.doFilter(request, response);
		}
	}
}
