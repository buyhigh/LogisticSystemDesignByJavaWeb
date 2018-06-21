package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.InStoreRequestDao;
import wuliu.dao.StoreRefGoodDao;
import wuliu.dao.impl.InStoreRequestDaoImpl;
import wuliu.dao.impl.StoreRefGoodDaoImpl;
import wuliu.dto.InStoreRequestDto;

public class ExecuteInStoreServlet extends HttpServlet {

	
	private static final long serialVersionUID = -4271168490405878837L;
	private InStoreRequestDao inStoreRequestDao = new InStoreRequestDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		//������񵥾����������
		//��ȡ"�����δִ��"���������
		List<InStoreRequestDto> listInStoreRequestDto = inStoreRequestDao.getInStoreRequestByState(2);
		if(listInStoreRequestDto.size() > 0 ){
			String[] idList = new String[listInStoreRequestDto.size()];
			for(int i = 0 ; i < listInStoreRequestDto.size() ; i++){
				InStoreRequestDto isrd = listInStoreRequestDto.get(i);
				idList[i] = isrd.getInStoreRequestId() + "";
				//���¿����
				int quantity = Integer.parseInt("-" + isrd.getGoodQuantity());
				storeRefGoodDao.updateStoreGood(isrd.getStoreId(), isrd.getGoodName(), quantity);
			}
			inStoreRequestDao.updateInStoreRequestState(idList, 5);
		}
		
		
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		listInStoreRequestDto = inStoreRequestDao.getInStoreRequestByState(5,pageNum);
		totalCount = inStoreRequestDao.getInStoreRequestByStateCount(5);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listInStoreRequestDto",listInStoreRequestDto);
		
		request.getRequestDispatcher("/kc/kc_execruku.jsp").forward(request, response);
	}
}
