package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.DispatchDao;
import wuliu.dao.TransferModelDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.TransferModelDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.DispatchDto;
import wuliu.dto.TransferToolDto;
import wuliu.entity.Dispatch;
import wuliu.entity.TransferModel;

public class ModifyDispatchServlet extends HttpServlet {

	
	private static final long serialVersionUID = 6060027973325828927L;
	private TransferModelDao transferModelDao = new TransferModelDaoImpl();
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String dispatchStr = request.getParameter("dispatch");
		int dispatch = -1;
		if(dispatchStr != null && !dispatchStr.equals("")){
			dispatch = Integer.parseInt(dispatchStr);
		}
		DispatchDto dispatchDto = dispatchDao.getDispatchById(dispatch);
		TransferToolDto curTransferToolDto = transferToolDao.getTransferToolById(dispatchDto.getTransferTool());//当前车辆
		TransferModel curTransferModel = transferModelDao.getTransferModelById(curTransferToolDto.getTransferModel());//当前车型
		List<TransferModel> listTransferModel = transferModelDao.getAllTransferModel();
		List<TransferToolDto> listTransferToolDto = transferToolDao.getTransferToolByModel(curTransferModel.getTrmoId());
		
		
		request.setAttribute("dispatchDto", dispatchDto);
		request.setAttribute("listTransferToolDto",listTransferToolDto);
		request.setAttribute("curTransferToolDto", curTransferToolDto);
		request.setAttribute("curTransferModel", curTransferModel);
		request.setAttribute("dispatchDto",dispatchDto);
		request.setAttribute("listTransferModel", listTransferModel);
		request.getRequestDispatcher("/jd/jd_modifypeisongdan.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		String dispatchDtoStr = request.getParameter("dispatchDto");
		int dispatchDto = -1;
		if(dispatchDtoStr != null && !dispatchDtoStr.equals("")){
			dispatchDto = Integer.parseInt(dispatchDtoStr);
		}
		
		String orderId = request.getParameter("orderId");
		String goodName = request.getParameter("goodName");
		String goodQuantityStr = request.getParameter("goodQuantity");
		int goodQuantity = -1;
		if(goodQuantityStr != null && !goodQuantityStr.equals("")){
			goodQuantity = Integer.parseInt(goodQuantityStr);
		}
		String transferToolStr = request.getParameter("transferTool");
		int transferTool = -1;
		if(transferToolStr != null && !transferToolStr.equals("")){
			transferTool = Integer.parseInt(transferToolStr);
		}
		String sendName = request.getParameter("sendName");
		String sendTel = request.getParameter("sendTel");
		String receiverName = request.getParameter("receiverName");
		String receiverTel = request.getParameter("receiverTel");
		String selProvince = request.getParameter("selProvince");
		String selCity = request.getParameter("selCity");
		String receiverStreet = request.getParameter("receiverStreet");
		
		Dispatch dispatch = new Dispatch();
		dispatch.setDispatchId(dispatchDto);
		dispatch.setOrderId(orderId);
		dispatch.setGoodName(goodName);
		dispatch.setGoodQuantity(goodQuantity);
		dispatch.setTransferTool(transferTool);
		dispatch.setSendName(sendName);
		dispatch.setSendTel(sendTel);
		dispatch.setReceiverName(receiverName);
		dispatch.setReceiverTel(receiverTel);
		dispatch.setReceiverProvince(selProvince);
		dispatch.setReceiverCity(selCity);
		dispatch.setReceiverStreet(receiverStreet);
		dispatchDao.updateDispatch(dispatch);
		request.getRequestDispatcher("/jd/querydispatch").forward(request,response);
	}
	
	
	
}
