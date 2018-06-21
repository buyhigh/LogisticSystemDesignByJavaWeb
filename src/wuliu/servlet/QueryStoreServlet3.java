package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.GoodsDao;
import wuliu.dao.StoreDao;
import wuliu.dao.impl.GoodsDaoImpl;
import wuliu.dao.impl.StoreDaoImpl;
import wuliu.dto.GoodsDto;
import wuliu.entity.Store;

public class QueryStoreServlet3 extends HttpServlet {

	private static final long serialVersionUID = 678692527746577004L;
	private StoreDao storeDao = new StoreDaoImpl();
	private GoodsDao goodsDao = new GoodsDaoImpl();
	protected void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int count = 0;//当前仓库下所有商品数
		int storeId = -1;//当前查询仓库ID
		int goodsId = -1;//当前查询商品ID
		GoodsDto goodDto = null;//当前仓库的某个商品
		Store curStore = null;//当前查询仓库
		List<GoodsDto> listGoodsDto = null;//当前查询仓库的所有商品列表
		
		//点击查询按钮时从表单获取仓库和商品参数
		String storeIdStr = request.getParameter("selLibrary");
		String goodsIdStr = request.getParameter("selGooks");
		
		//点击分页链接时获取分页参数和当前仓库ID参数
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
			if(storeIdStr == null){
				storeIdStr = request.getParameter("storeId");
			}
		}
		
		//判断获得参数的有效性
		if(storeIdStr != null && !storeIdStr.equals("")){
			storeId = Integer.parseInt(storeIdStr);
		}
		if(goodsIdStr != null && !goodsIdStr.equals("")){
			goodsId = Integer.parseInt(goodsIdStr);
		}
		
		
		if(storeId != -1 && goodsId != -1){//表示查询某个仓库单个商品
			goodDto = goodsDao.getGoods(storeId, goodsId);
		}else if(storeId != -1 && goodsId == -1){//表示查询某个仓库的所有商品
			count = goodsDao.getGoodsNumByStoreId(storeId);
			if(count % 10 == 0){
				maxPageNum = count / 10;
			}else{
				maxPageNum = count / 10 + 1;
			}
			listGoodsDto = goodsDao.getGoodsByStoreId(storeId,pageNum);
			request.setAttribute("count",count);
			request.setAttribute("maxPageNum",maxPageNum);
		}
		curStore = storeDao.getStoreByStoreId(storeId);
		List<Store> listStore = storeDao.getAllStore();
		List<GoodsDto> listGoodsDto2 = goodsDao.getGoodsByStoreId(storeId);
		
		request.setAttribute("curPage", pageNum);
		request.setAttribute("listGoodsDto2", listGoodsDto2);
		request.setAttribute("store", curStore);
		request.setAttribute("goodDto",goodDto);
		request.setAttribute("listStore", listStore);
		request.setAttribute("listGoodsDto", listGoodsDto);
		request.getRequestDispatcher("/kc/kc_querykuchun.jsp").forward(request, response);
	}
	
}
