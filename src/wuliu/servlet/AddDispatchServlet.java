package wuliu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.dao.DispatchDao;
import wuliu.dao.TransferModelDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.TransferModelDaoImpl;
import wuliu.entity.Dispatch;
import wuliu.entity.TransferModel;
import wuliu.entity.User;

public class AddDispatchServlet extends HttpServlet {

	private static final long serialVersionUID = 3694799301793903093L;
	private TransferModelDao transferModelDao = new TransferModelDaoImpl();
	private DispatchDao dispatchDao = new DispatchDaoImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		List<TransferModel> listTransferModel = transferModelDao
				.getAllTransferModel();
		request.setAttribute("listTransferModel", listTransferModel);
		request.getRequestDispatcher("/jd/jd_zhengjiapeisongdan.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		System.out.println("准备处理配送单");
		HttpSession session = request.getSession();
		String Creater =((User) session.getAttribute("loginUser")).getUserName();
		System.out.println(Creater);
		String orderId = request.getParameter("orderId");
		String goodName = request.getParameter("goodName");
		String goodQuantityStr = request.getParameter("goodQuantity");
		int goodQuantity = -1;
		if (goodQuantityStr != null && !goodQuantityStr.equals("")) {
			goodQuantity = Integer.parseInt(goodQuantityStr);
		}
		String transferToolStr = request.getParameter("transferTool");
		int transferTool = -1;
		if (transferToolStr != null && !transferToolStr.equals("")) {
			transferTool = Integer.parseInt(transferToolStr);
		}
		String sendName = request.getParameter("sendName");
		String sendTel = request.getParameter("sendTel");
		String receiverName = request.getParameter("receiverName");
		String receiverTel = request.getParameter("receiverTel");
		String selProvince = request.getParameter("selProvince");
		String selCity = request.getParameter("selCity");
		String receiverStreet = request.getParameter("receiverStreet");
		int state = 1;
		String orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		Dispatch dispatch = new Dispatch();
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
		dispatch.setState(state);
		dispatch.setOrderDate(orderDate);
		dispatch.setCreater(Creater);
		dispatchDao.addDispatch(dispatch);//增加配送单，不用修改
		response.sendRedirect("querydispatch");
	}

}
