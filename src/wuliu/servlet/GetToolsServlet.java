package wuliu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.TransferToolDto;

public class GetToolsServlet extends HttpServlet{

	private static final long serialVersionUID = 4788683859220195113L;
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		String transferModelStr = request.getParameter("transferModelStr");
		int transferModel = -1;
		if(transferModelStr != null && !transferModelStr.equals("")){
			transferModel = Integer.parseInt(transferModelStr);
		}
		List<TransferToolDto> listTransferToolDto = transferToolDao.getTransferToolByModel(transferModel); 
		PrintWriter out = response.getWriter();
		String outStr = "";
		for(int i = 0 ; i < listTransferToolDto.size() ; i++){
			if(i == 0){
				outStr += listTransferToolDto.get(i).getTransferId() + ":" + listTransferToolDto.get(i).getTransferName();
			}else{
				outStr += ";" + listTransferToolDto.get(i).getTransferId() + ":" + listTransferToolDto.get(i).getTransferName();
			}
		}
		out.print(outStr);
	}
	
}
