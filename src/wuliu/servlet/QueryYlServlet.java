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
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		
		//�����ѯ��ťʱ��ȡ��ǰѡ�е�����㣬�������ͣ���������
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
		
		//��������ӻ�ȡ��ҳ��Ϣ����ǰѡ�е�����㣬�������ͣ���������
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
		
		
		//��ҳ
		List<TransferToolDto> listTransferToolDto = null;
		TransferToolDto curTransferToolDto = null;
		//���ָ�����͵����г�����Ϣ
		List<TransferToolDto> listTransferToolDto3 = null;
		//��ѯָ�����������г���
		if(curTransferPlace != -1 && curTransferModel == -1 && curTransferTool == -1){
			listTransferToolDto = transferToolDao.getTransferToolByPlace(curTransferPlace,pageNum);
			totalCount = transferToolDao.getgetTransferToolByPlaceCount(curTransferPlace);
		}else if(curTransferPlace != -1 && curTransferModel != -1 && curTransferTool == -1){//��ѯָ�������ָ�����͵����г���
			listTransferToolDto = transferToolDao.getTransferTool(curTransferPlace, curTransferModel,pageNum);
			listTransferToolDto3 = transferToolDao.getTransferToolByModel(curTransferModel);
			totalCount = transferToolDao.getTransferToolCount(curTransferPlace, curTransferModel);
		}else if(curTransferPlace != -1 && curTransferModel != -1 && curTransferTool != -1){//��ѯָ�������ָ������ָ����������Ϣ
			curTransferToolDto = transferToolDao.getTransferToolById(curTransferTool);
			listTransferToolDto3 = transferToolDao.getTransferToolByModel(curTransferModel);
		}
		
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		//Ϊ�˱���״̬��ȡ���������
		List<TransferPlace> listTransferPlace = transferPlaceDao.getAllTransferPlace();
		//Ϊ�˱���״̬��ȡ��ǰ���������г�����Ϣ
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
