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

public class GetGoodPriceServlet extends HttpServlet {

	private static final long serialVersionUID = -7169610073917951649L;
	private GoodsDao goodsDao = new GoodsDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		response.setCharacterEncoding("utf-8");//传到页面上进行编码
		String goodsName = new String(request.getParameter("goodsName").getBytes("iso8859-1"),"utf-8");//传到服务器上进行解码
		List<GoodsDto> listGoodsDto = goodsDao.getGoodByGoodName(goodsName);
		String result = "0";
		String    price = "0";
		if(listGoodsDto.size() > 0){//检查是否有
			result = "1";
			for (int i=0; i<listGoodsDto.size(); i++) {
				price = listGoodsDto.get(i).getGoodPrice();
			}
		}
		
		PrintWriter out = response.getWriter();//设置对象
		out.print(price);//返回值
	}

}
