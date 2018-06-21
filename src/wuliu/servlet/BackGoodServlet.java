package wuliu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.GoodsDao;
import wuliu.dao.InStoreRequestDao;
import wuliu.dao.StoreDao;
import wuliu.dao.StoreRefGoodDao;
import wuliu.dao.impl.GoodsDaoImpl;
import wuliu.dao.impl.InStoreRequestDaoImpl;
import wuliu.dao.impl.StoreDaoImpl;
import wuliu.dao.impl.StoreRefGoodDaoImpl;
import wuliu.dto.GoodsDto;
import wuliu.entity.Goods;
import wuliu.entity.InStoreRequest;
import wuliu.entity.Store;
import wuliu.entity.StoreRefGood;

public class BackGoodServlet extends HttpServlet {

	private static final long serialVersionUID = 2178125110406812159L;
	private StoreDao storeDao = new StoreDaoImpl();
	private GoodsDao goodsDao = new GoodsDaoImpl();
	private InStoreRequestDao inStoreRequestDao = new InStoreRequestDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		List<Store> listStore = storeDao.getAllStore();
		request.setAttribute("listStore", listStore);
		request.getRequestDispatcher("/kc/kc_backgood.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String quality = request.getParameter("rdque");
		if(quality.equals("0")){
			//货有问题，生成入库单,入"退货仓库"
			Store store = storeDao.getStoreByName("退货仓库");
			String goodName = request.getParameter("goodName");//产品名称
			List<GoodsDto> listGoodsDto = goodsDao.getGoodByGoodName(goodName);
			int storeId = store.getStoreId();
			int quantity = Integer.parseInt(request.getParameter("goodQuantity"));
			
			int i = 0;
			for(; i < listGoodsDto.size() ; i++){
				if(storeId == listGoodsDto.get(i).getStoreId()){
					break;
				}
			}
			if(i == listGoodsDto.size()){
				//表明该产品在storeid仓库还没有对应的库存信息,即需要增加库存信息
				StoreRefGood srf = new StoreRefGood();
				srf.setStoreId(storeId);
				srf.setGoodsId(listGoodsDto.get(0).getGoodId());
				srf.setNum(quantity);
				storeRefGoodDao.addStoreGood(srf);
				//生成入库单
				String inDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//入库请求单的生成时间
				int state = 5;
				InStoreRequest isr = new InStoreRequest();
				isr.setStoreId(storeId);
				isr.setGoodsId(listGoodsDto.get(0).getGoodId());
				isr.setInDate(inDate);
				isr.setGoodQuantity(quantity);
				isr.setStateId(state);
				inStoreRequestDao.addInStoreRequest(isr);
			}else{
				//表明该产品在storeid仓库已有对应的库存信息，只需更新库库存即可
				storeRefGoodDao.updateStoreGood(storeId, goodName, Integer.parseInt("-" + quantity));
			}
			
		}else if(quality.equals("1")){
			//货没有问题，生成入库单,入"选择的仓库"
			int storeId = Integer.parseInt(request.getParameter("selStore"));//入库仓库
			int quantity = Integer.parseInt(request.getParameter("goodQuantity"));//产品数量
			String goodName = request.getParameter("goodName");//产品名称
			List<GoodsDto> listGoodsDto = goodsDao.getGoodByGoodName(goodName);
			int goodsId = -1;
			if(listGoodsDto.size() == 0){
				//新增产品
				System.out.println("debug1");
				String goodWeight = request.getParameter("goodWeight");
				String goodBulk = request.getParameter("goodBulk");
				String goodUnit = request.getParameter("goodUnit");
				String goodPrice = request.getParameter("goodPrice");
				Goods newGood = new Goods();
				newGood.setGoodName(goodName);
				newGood.setGoodWeight(goodWeight);
				newGood.setGoodBulk(goodBulk);
				newGood.setGoodUnit(goodUnit);
				newGood.setGoodPrice(goodPrice);
				newGood.setInDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//入库时间
				goodsId = goodsDao.addGoods(newGood);//新增产品ID
				StoreRefGood srf = new StoreRefGood();
				srf.setGoodsId(goodsId);
				srf.setNum(quantity);
				srf.setStoreId(storeId);
				storeRefGoodDao.addStoreGood(srf);//增加库存信息
				//生成入库单
				String inDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//入库请求单的生成时间
				int state = 5;
				InStoreRequest isr = new InStoreRequest();
				isr.setStoreId(storeId);
				isr.setGoodsId(goodsId);
				isr.setInDate(inDate);
				isr.setGoodQuantity(quantity);
				isr.setStateId(state);
				inStoreRequestDao.addInStoreRequest(isr);
			}else{
				int i = 0;
				System.out.println("debug2");
				for(; i < listGoodsDto.size() ; i++){
					if(storeId == listGoodsDto.get(i).getStoreId()){
						break;
					}
				}
				if(i == listGoodsDto.size()){
					System.out.println("debug3");
					//表明该产品在storeid仓库还没有对应的库存信息,即需要增加库存信息
					StoreRefGood srf = new StoreRefGood();
					srf.setStoreId(storeId);
					srf.setGoodsId(listGoodsDto.get(0).getGoodId());
					srf.setNum(quantity);
					storeRefGoodDao.addStoreGood(srf);
					//生成入库单
					String inDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//入库请求单的生成时间
					int state = 5;
					InStoreRequest isr = new InStoreRequest();
					isr.setStoreId(storeId);
					isr.setGoodsId(listGoodsDto.get(0).getGoodId());
					isr.setInDate(inDate);
					isr.setGoodQuantity(quantity);
					isr.setStateId(state);
					inStoreRequestDao.addInStoreRequest(isr);
				}else{
					//表明该产品在storeid仓库已有对应的库存信息，只需更新库库存即可
					System.out.println("debug4");
					storeRefGoodDao.updateStoreGood(storeId, goodName, Integer.parseInt("-" + quantity));
				}
			}
		}
		response.sendRedirect("querystore3");
	}

}
