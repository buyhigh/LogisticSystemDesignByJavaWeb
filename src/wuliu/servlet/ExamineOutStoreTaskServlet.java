package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.OutStoreTaskDao;
import wuliu.dao.StoreRefGoodDao;
import wuliu.dao.impl.OutStoreTaskDaoImpl;
import wuliu.dao.impl.StoreRefGoodDaoImpl;
import wuliu.dto.OutStoreTaskDto;
import wuliu.entity.StoreRefGood;

public class ExamineOutStoreTaskServlet extends HttpServlet {

	
	private static final long serialVersionUID = 8682696446931610733L;
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	private OutStoreTaskDao outStoreTaskDao = new OutStoreTaskDaoImpl();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		List<OutStoreTaskDto> listOutStoreTaskDto = outStoreTaskDao.getOutStoreTaskDtoByState(1, pageNum);
		totalCount = outStoreTaskDao.getOutStoreTaskDtoByStateCount(1);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listOutStoreTaskDto", listOutStoreTaskDto);
		request.getRequestDispatcher("/kc/kc_shenhechukudan.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		//获取待审核的出库任务单ID列表
		String[] idList = request.getParameterValues("chkItem");
		for(int i = 0 ; i < idList.length ; i++){
			OutStoreTaskDto ostd = outStoreTaskDao.getOutStoreTaskDtoById(Integer.parseInt(idList[i]));
			StoreRefGood srf = storeRefGoodDao.examineOutStoreRequest(ostd.getStoreId(), ostd.getGoodName(), ostd.getGoodQuantity());
			if(srf != null){
				//库存满足，审核通过，修改单据状态为"已审核未执行2"
				outStoreTaskDao.updateOutStoreTaskState(ostd.getOutStoreTaskId(), 2);//修改状态，那这个单是什么时候生成的
			}else{
				//库存不满足，审核未通过，修改单据状态为"未满足条件3"
				outStoreTaskDao.updateOutStoreTaskState(ostd.getOutStoreTaskId(),3);
			}
		}
		response.sendRedirect("querycuku");
	}
	
	
}
