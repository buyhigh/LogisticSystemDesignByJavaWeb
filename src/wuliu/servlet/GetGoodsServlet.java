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

public class GetGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = -3465155832195827049L;
	
	private GoodsDao goodsDao = new GoodsDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置解码方式
		response.setCharacterEncoding("utf-8");
		
		String storeStr = request.getParameter("storeId");
		int storeId = -1;
		if(storeStr != null && !storeStr.equals("")){
			storeId = Integer.parseInt(request.getParameter("storeId"));
		}
		List<GoodsDto> listGoods = goodsDao.getGoodsByStoreId(storeId);
		PrintWriter out = response.getWriter();
		String outStr = "";
		for(int i = 0 ; i < listGoods.size(); i++){
			if(i == 0){
				outStr += listGoods.get(i).getGoodId() + ":" + listGoods.get(i).getGoodName();
			}else{
				outStr += ";" + listGoods.get(i).getGoodId() + ":" + listGoods.get(i).getGoodName();
			}
		}
		out.print(outStr);
		out.close();
	}

}
