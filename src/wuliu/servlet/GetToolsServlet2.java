package wuliu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.TransferModelDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.TransferModelDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.TransferToolDto;

public class GetToolsServlet2 extends HttpServlet {

	
	private static final long serialVersionUID = -9199972686040089481L;
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	private TransferModelDao transferModelDao = new TransferModelDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String transferPlaceStr = request.getParameter("transferPlaceStr");
		int transferPlace = -1;
		if(transferPlaceStr != null && !transferPlaceStr.equals("")){
			transferPlace = Integer.parseInt(transferPlaceStr);
		}
		List<TransferToolDto> listTransferToolDto = transferToolDao.getTransferToolByPlace(transferPlace);
		List<Integer> listModelId = new ArrayList<Integer>();
		for(int i = 0; i < listTransferToolDto.size(); i++){
			if(!listModelId.contains(listTransferToolDto.get(i).getTransferModel())){
				listModelId.add(listTransferToolDto.get(i).getTransferModel());
			}
		}
		PrintWriter out = response.getWriter();
		String outStr = "";
		for(int i = 0 ; i < listModelId.size() ; i++){
			if(i == 0){
				outStr += listTransferToolDto.get(i).getTransferModel() + ":" + transferModelDao.getTransferModelById(listModelId.get(i)).getTrmoName();
			}else{
				outStr += ";" + listTransferToolDto.get(i).getTransferModel() + ":" + transferModelDao.getTransferModelById(listModelId.get(i)).getTrmoName();
			}
		}
		out.print(outStr);
	}
	
}
