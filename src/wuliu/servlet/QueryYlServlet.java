package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.TransferPlaceDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.TransferPlaceDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.TransferToolDto;
import wuliu.entity.TransferPlace;

public class QueryYlServlet extends HttpServlet {

	
	private static final long serialVersionUID = -8251074230010992435L;
	private TransferPlaceDao transferPlaceDao = new TransferPlaceDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	
	
	protected void service(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		
		//点击查询按钮时获取当前选中的运输点，运力类型，运力工具
		String curTransferPlaceStr = request.getParameter("selPlace");
		String curTransferModelStr = request.getParameter("selModel");
		String curTransferToolStr = request.getParameter("selTool");
		int curTransferPlace = -1;
		int curTransferModel = -1;
		int curTransferTool = -1;
		if(curTransferPlaceStr != null && !curTransferPlaceStr.equals("")){
			curTransferPlace = Integer.parseInt(curTransferPlaceStr);
		}
		if(curTransferModelStr != null && !curTransferModelStr.equals("")){
			curTransferModel = Integer.parseInt(curTransferModelStr);
		}
		if(curTransferToolStr != null && !curTransferToolStr.equals("")){
			curTransferTool = Integer.parseInt(curTransferToolStr);
		}
		
		//点击超链接获取分页信息及当前选中的运输点，运力类型，运力工具
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
			String curSelPlaceStr = request.getParameter("curSelPlace");
			String curSelModelStr = request.getParameter("curSelModel");
			if(curSelPlaceStr != null && !curSelPlaceStr.equals("")){
				curTransferPlace = Integer.parseInt(curSelPlaceStr);
			}
			if(curSelModelStr != null && !curSelModelStr.equals("")){
				curTransferModel = Integer.parseInt(curSelModelStr);
			}
			
		}
		
		
		//分页
		List<TransferToolDto> listTransferToolDto = null;
		TransferToolDto curTransferToolDto = null;
		//存放指定车型的所有车辆信息
		List<TransferToolDto> listTransferToolDto3 = null;
		//查询指定运输点的所有车辆
		if(curTransferPlace != -1 && curTransferModel == -1 && curTransferTool == -1){
			listTransferToolDto = transferToolDao.getTransferToolByPlace(curTransferPlace,pageNum);
			totalCount = transferToolDao.getgetTransferToolByPlaceCount(curTransferPlace);
		}else if(curTransferPlace != -1 && curTransferModel != -1 && curTransferTool == -1){//查询指定运输点指定车型的所有车辆
			listTransferToolDto = transferToolDao.getTransferTool(curTransferPlace, curTransferModel,pageNum);
			listTransferToolDto3 = transferToolDao.getTransferToolByModel(curTransferModel);
			totalCount = transferToolDao.getTransferToolCount(curTransferPlace, curTransferModel);
		}else if(curTransferPlace != -1 && curTransferModel != -1 && curTransferTool != -1){//查询指定运输点指定车型指定车辆的信息
			curTransferToolDto = transferToolDao.getTransferToolById(curTransferTool);
			listTransferToolDto3 = transferToolDao.getTransferToolByModel(curTransferModel);
		}
		
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		//为了保存状态获取所有运输点
		List<TransferPlace> listTransferPlace = transferPlaceDao.getAllTransferPlace();
		//为了保存状态获取当前运输点的所有车型信息
		List<TransferToolDto> listTransferToolDto2 = transferToolDao.getTransferToolByPlace(curTransferPlace);
		
		
		
		request.setAttribute("count",totalCount);
		request.setAttribute("maxPage",maxPageNum);
		request.setAttribute("curPage", pageNum);
		request.setAttribute("listTransferToolDto3",listTransferToolDto3);
		request.setAttribute("listTransferToolDto2",listTransferToolDto2);
		request.setAttribute("listTransferPlace", listTransferPlace);
		request.setAttribute("listTransferToolDto", listTransferToolDto);
		request.setAttribute("curTransferToolDto",curTransferToolDto);
		request.setAttribute("curTransferPlace", curTransferPlace);
		request.setAttribute("curTransferModel", curTransferModel);
		request.setAttribute("curTransferTool", curTransferTool);
		//request.getRequestDispatcher("/dd/dd_chaxunyunli.jsp").forward(request, response);
		request.getRequestDispatcher("/kc/dd_chaxunyunli.jsp").forward(request, response);
	}
	
	
}
