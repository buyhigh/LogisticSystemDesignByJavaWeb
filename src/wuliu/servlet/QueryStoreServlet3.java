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
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int count = 0;//��ǰ�ֿ���������Ʒ��
		int storeId = -1;//��ǰ��ѯ�ֿ�ID
		int goodsId = -1;//��ǰ��ѯ��ƷID
		GoodsDto goodDto = null;//��ǰ�ֿ��ĳ����Ʒ
		Store curStore = null;//��ǰ��ѯ�ֿ�
		List<GoodsDto> listGoodsDto = null;//��ǰ��ѯ�ֿ��������Ʒ�б�
		
		//�����ѯ��ťʱ�ӱ���ȡ�ֿ����Ʒ����
		String storeIdStr = request.getParameter("selLibrary");
		String goodsIdStr = request.getParameter("selGooks");
		
		//�����ҳ����ʱ��ȡ��ҳ�����͵�ǰ�ֿ�ID����
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
			if(storeIdStr == null){
				storeIdStr = request.getParameter("storeId");
			}
		}
		
		//�жϻ�ò�������Ч��
		if(storeIdStr != null && !storeIdStr.equals("")){
			storeId = Integer.parseInt(storeIdStr);
		}
		if(goodsIdStr != null && !goodsIdStr.equals("")){
			goodsId = Integer.parseInt(goodsIdStr);
		}
		
		
		if(storeId != -1 && goodsId != -1){//��ʾ��ѯĳ���ֿⵥ����Ʒ
			goodDto = goodsDao.getGoods(storeId, goodsId);
		}else if(storeId != -1 && goodsId == -1){//��ʾ��ѯĳ���ֿ��������Ʒ
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
