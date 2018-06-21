package wuliu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.DispatchDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.DispatchDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.DispatchDto;
import wuliu.dto.TransferToolDto;

public class GetDispatchDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 4615531989489724173L;
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		response.setCharacterEncoding("utf-8");
		String dispatch = new String(request.getParameter("dispatch").getBytes("iso8859-1"),"utf-8");
		DispatchDto dispatchDto = dispatchDao.getDispatchById(Integer.parseInt(dispatch));
		TransferToolDto transferToolDto = transferToolDao.getTransferToolById(dispatchDto.getTransferTool());
		String str = dispatchDto.getOrderId() + ":"
					+ dispatchDto.getGoodName() + ":"
					+ dispatchDto.getGoodQuantity() + ":"
					+ transferToolDto.getTransferName() + ":"
					+ dispatchDto.getSendName() + ":"
					+ dispatchDto.getSendTel() + ":"
					+ dispatchDto.getReceiverName() + ":"
					+ dispatchDto.getReceiverTel() + ":"
					+ dispatchDto.getReceiverStreet();
		PrintWriter out = response.getWriter();
		out.print(str);
	}
}
