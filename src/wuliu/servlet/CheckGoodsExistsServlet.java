package wuliu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.GoodsDao;
import wuliu.dao.impl.GoodsDaoImpl;
import wuliu.dto.GoodsDto;

public class CheckGoodsExistsServlet extends HttpServlet {

	private static final long serialVersionUID = -7169610073917951649L;
	private GoodsDao goodsDao = new GoodsDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		response.setCharacterEncoding("utf-8");//传到页面上进行编码
		String goodsName = new String(request.getParameter("goodsName").getBytes("iso8859-1"),"utf-8");//传到服务器上进行解码
		List<GoodsDto> listGoodsDto = goodsDao.getGoodByGoodName(goodsName);
		String result = "0";
		if(listGoodsDto.size() > 0){
			result = "1";
		}
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
