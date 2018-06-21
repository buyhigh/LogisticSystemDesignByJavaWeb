package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.dao.TransferPlaceDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.TransferPlaceDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.TransferToolDto;
import wuliu.entity.TransferPlace;

public class CarStateChangeServlet extends HttpServlet {
	
	private TransferPlaceDao transferPlaceDao = new TransferPlaceDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.sendRedirect("CarManager");
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		String carid = request.getParameter("selectcar");
		String carstate = request.getParameter("selectstate");
		System.out.println(carid);
		System.out.println(carstate);
		if (carstate.equals("Œ¨–ﬁ")) {
			transferToolDao.updateTransferToolState(Integer.parseInt(carid), 3);
			System.out.println("debug2");
		}
		else if(carstate.equals("ø’œ–")) {
			transferToolDao.updateTransferToolState(Integer.parseInt(carid), 1);
			System.out.println("debug3");
		}
		response.sendRedirect("CarManager");
	}

}