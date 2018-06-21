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
			//�������⣬������ⵥ,��"�˻��ֿ�"
			Store store = storeDao.getStoreByName("�˻��ֿ�");
			String goodName = request.getParameter("goodName");//��Ʒ����
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
				//�����ò�Ʒ��storeid�ֿ⻹û�ж�Ӧ�Ŀ����Ϣ,����Ҫ���ӿ����Ϣ
				StoreRefGood srf = new StoreRefGood();
				srf.setStoreId(storeId);
				srf.setGoodsId(listGoodsDto.get(0).getGoodId());
				srf.setNum(quantity);
				storeRefGoodDao.addStoreGood(srf);
				//������ⵥ
				String inDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//������󵥵�����ʱ��
				int state = 5;
				InStoreRequest isr = new InStoreRequest();
				isr.setStoreId(storeId);
				isr.setGoodsId(listGoodsDto.get(0).getGoodId());
				isr.setInDate(inDate);
				isr.setGoodQuantity(quantity);
				isr.setStateId(state);
				inStoreRequestDao.addInStoreRequest(isr);
			}else{
				//�����ò�Ʒ��storeid�ֿ����ж�Ӧ�Ŀ����Ϣ��ֻ����¿��漴��
				storeRefGoodDao.updateStoreGood(storeId, goodName, Integer.parseInt("-" + quantity));
			}
			
		}else if(quality.equals("1")){
			//��û�����⣬������ⵥ,��"ѡ��Ĳֿ�"
			int storeId = Integer.parseInt(request.getParameter("selStore"));//���ֿ�
			int quantity = Integer.parseInt(request.getParameter("goodQuantity"));//��Ʒ����
			String goodName = request.getParameter("goodName");//��Ʒ����
			List<GoodsDto> listGoodsDto = goodsDao.getGoodByGoodName(goodName);
			int goodsId = -1;
			if(listGoodsDto.size() == 0){
				//������Ʒ
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
				newGood.setInDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//���ʱ��
				goodsId = goodsDao.addGoods(newGood);//������ƷID
				StoreRefGood srf = new StoreRefGood();
				srf.setGoodsId(goodsId);
				srf.setNum(quantity);
				srf.setStoreId(storeId);
				storeRefGoodDao.addStoreGood(srf);//���ӿ����Ϣ
				//������ⵥ
				String inDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//������󵥵�����ʱ��
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
					//�����ò�Ʒ��storeid�ֿ⻹û�ж�Ӧ�Ŀ����Ϣ,����Ҫ���ӿ����Ϣ
					StoreRefGood srf = new StoreRefGood();
					srf.setStoreId(storeId);
					srf.setGoodsId(listGoodsDto.get(0).getGoodId());
					srf.setNum(quantity);
					storeRefGoodDao.addStoreGood(srf);
					//������ⵥ
					String inDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//������󵥵�����ʱ��
					int state = 5;
					InStoreRequest isr = new InStoreRequest();
					isr.setStoreId(storeId);
					isr.setGoodsId(listGoodsDto.get(0).getGoodId());
					isr.setInDate(inDate);
					isr.setGoodQuantity(quantity);
					isr.setStateId(state);
					inStoreRequestDao.addInStoreRequest(isr);
				}else{
					//�����ò�Ʒ��storeid�ֿ����ж�Ӧ�Ŀ����Ϣ��ֻ����¿��漴��
					System.out.println("debug4");
					storeRefGoodDao.updateStoreGood(storeId, goodName, Integer.parseInt("-" + quantity));
				}
			}
		}
		response.sendRedirect("querystore3");
	}

}
