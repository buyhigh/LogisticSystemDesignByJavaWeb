package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.DispatchDao;
import wuliu.dao.GoodsDao;
import wuliu.dao.OutStoreRequestDao;
import wuliu.dao.StateDao;
import wuliu.dao.StoreRefGoodDao;
import wuliu.dao.TransferModelDao;
import wuliu.dao.TransferRequestDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.GoodsDaoImpl;
import wuliu.dao.impl.OutStoreRequestDaoImpl;
import wuliu.dao.impl.StateDaoImpl;
import wuliu.dao.impl.StoreRefGoodDaoImpl;
import wuliu.dao.impl.TransferModelDaoImpl;
import wuliu.dao.impl.TransferRequestDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.DispatchDto;
import wuliu.dto.GoodsDto;
import wuliu.dto.TransferToolDto;
import wuliu.entity.Dispatch;
import wuliu.entity.OutStoreRequest;
import wuliu.entity.StoreRefGood;
import wuliu.entity.TransferModel;
import wuliu.entity.TransferRequest;

public class ExamineServlet extends HttpServlet {

	private static final long serialVersionUID = -4144120819315118960L;
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	private StateDao stateDao = new StateDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	private OutStoreRequestDao outStoreRequestDao = new OutStoreRequestDaoImpl();
	private TransferRequestDao transferRequestDao = new TransferRequestDaoImpl();
	private GoodsDao goodsDao = new GoodsDaoImpl();
	private TransferModelDao transferModelDao = new TransferModelDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		int pageNum = 1;//当前页码
		int maxPage = 1;//最大页码
		int rowCount = 0;
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		int state = stateDao.getStateByName("未审核").getStateId();
		List<DispatchDto> listDispatchDto = dispatchDao.getDispatchByState(state,pageNum);
		rowCount = dispatchDao.getDispatchCount(state);
		if(rowCount % 10 == 0){
			maxPage = rowCount / 10;
		}else{
			maxPage = rowCount / 10 + 1;
		}
		request.setAttribute("curPage", pageNum);
		request.setAttribute("maxPage",maxPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("listDispatchDto", listDispatchDto);
		request.getRequestDispatcher("/jd/jd_shenhepeisongdan.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String operateStr = request.getParameter("operate");
		int operate = -1;
		if(operateStr != null && !operateStr.equals("")){
			operate = Integer.parseInt(operateStr);
		}
		System.out.println("配送单审核debug1");
		
		String[] dispatchIdList = request.getParameterValues("chkItem");//待审核或待删除的配送通知单ID列表
		switch(operate){
		case 1:
			//删除操作
			dispatchDao.deleteDispatchByIdList(dispatchIdList);
			int state = stateDao.getStateByName("未审核").getStateId();
			List<DispatchDto> listDispatchDto = dispatchDao.getDispatchByState(state);
			request.setAttribute("listDispatchDto", listDispatchDto);
			request.getRequestDispatcher("/jd/jd_shenhepeisongdan.jsp").forward(request, response);
			break;
		case 2:
			//审核操作
			System.out.println("进行配送单审核");
			for(int i = 0 ; i < dispatchIdList.length ; i++){
				//获取待审核的配送通知单
				Dispatch dispatch = dispatchDao.getDispatchById(Integer.parseInt(dispatchIdList[i]));
				StoreRefGood storeRefGood = storeRefGoodDao.examineDispatch(dispatch.getGoodName(), dispatch.getGoodQuantity());
				//审核通过
				if(storeRefGood != null){//如果货物满足发货需求则进行审核单通过
					
					//修改配送通知单状态为"已审核未执行"
					dispatchDao.updateDispatchState(dispatch.getDispatchId(), 2);
					//修改配送通知单状态
					
					
					//生成出库请求单
					OutStoreRequest outStoreRequest = new OutStoreRequest();
					outStoreRequest.setDispatchId(dispatch.getDispatchId());
					outStoreRequest.setStoreId(storeRefGood.getStoreId());
					outStoreRequest.setState(1);
					outStoreRequestDao.addOutStoreRequest(outStoreRequest);//生成出库请求单
					//生成出库请求单
					
					
					//生成运输请求单
					//获取需要运输的商品信息（数量，载重，体积），决定需要的车辆数目
					GoodsDto goodsDto = goodsDao.getGoodByGoodName(dispatch.getGoodName()).get(0);
					double reqWeight = dispatch.getGoodQuantity() * Double.parseDouble(goodsDto.getGoodWeight()) / 2000;//需求的重量
					double reqMulk = dispatch.getGoodQuantity() * Double.parseDouble(goodsDto.getGoodBulk()) / 1000000;//需求的空间
					//获取运输车辆类型信息
					TransferToolDto transferToolDto = transferToolDao.getTransferToolById(dispatch.getTransferTool());
					TransferModel transferModel = transferModelDao.getTransferModelById(transferToolDto.getTransferModel());
					double factWeight = Double.parseDouble(transferModel.getTrmoWeight());
					double factMulk = Double.parseDouble(transferModel.getTrmoMulk());
					TransferRequest transferRequest = new TransferRequest();
					transferRequest.setDispatchId(dispatch.getDispatchId());
					transferRequest.setTransferToolId(dispatch.getTransferTool());
					transferRequest.setState(1);
					int requestNum = 1;
					while(reqWeight > factWeight || reqMulk > factMulk){
						requestNum++;
						factWeight += factWeight;
						factMulk += factMulk;
					}
					transferRequest.setRequestNum(requestNum);
					transferRequestDao.addTransferRequest(transferRequest);//生成运输请求单
					//生成运输请求单
				}else{
					//审核未通过,修改配送通知单的状态为"未满足条件"
					dispatchDao.updateDispatchState(dispatch.getDispatchId(), 3);
				}
			}
			break;
		}
		response.sendRedirect("querydispatch");
		
	}

}
