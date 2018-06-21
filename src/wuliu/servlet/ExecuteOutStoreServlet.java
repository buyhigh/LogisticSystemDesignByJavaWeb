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
import wuliu.entity.SaveDivStore;
import wuliu.dao.SaveDivStoreDao;
import wuliu.dao.impl.SaveDivStoreDaoImpl;

import wuliu.dao.DispatchDao;
import wuliu.dao.impl.DispatchDaoImpl;

public class ExecuteOutStoreServlet extends HttpServlet {

	
	private static final long serialVersionUID = -1577857429764770489L;
	private OutStoreTaskDao outStoreTaskDao = new OutStoreTaskDaoImpl();
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	private StoreRefGoodDao storeRefGoodDao = new StoreRefGoodDaoImpl();
	private SaveDivStoreDao saveDivStoreDao = new SaveDivStoreDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		
		
		//获取"已审核未执行"的出库任务单
		List<OutStoreTaskDto> listOutStoreTaskDto = outStoreTaskDao.getOutStoreTaskDtoByState(2);
		System.out.println("debug1");
		
		
		
		
		//改变出库任务单状态为"已执行"
		//状态为"已执行"的出库任务单即为出库单
		for(int i = 0 ; i < listOutStoreTaskDto.size() ; i++){
			outStoreTaskDao.updateOutStoreTaskState(listOutStoreTaskDto.get(i).getOutStoreTaskId(), 5);
			int dsipatchid = outStoreTaskDao.getDispatchIdByOutStoreTaskId(listOutStoreTaskDto.get(i).getOutStoreTaskId());
			System.out.println("dsipatchid" + dsipatchid);
			dispatchDao.updateDispatchState(dsipatchid,5);
			System.out.println("debug2");
			int ifexistdivstoreid = saveDivStoreDao.getDivStoreIdByOutStoreTask(listOutStoreTaskDto.get(i).getOutStoreTaskId());
			if (ifexistdivstoreid > 0) {
				saveDivStoreDao.UpdateSaveDivStore(ifexistdivstoreid,5);//设置单独库存单状态已经执行
			}
			else {
				//更新库存量
				storeRefGoodDao.updateStoreGood(listOutStoreTaskDto.get(i).getStoreId(), listOutStoreTaskDto.get(i).getGoodName(), listOutStoreTaskDto.get(i).getGoodQuantity());
			}
		}
		
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		listOutStoreTaskDto = outStoreTaskDao.getOutStoreTaskDtoByState(5,pageNum);
		totalCount = outStoreTaskDao.getOutStoreTaskDtoByStateCount(5);
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listOutStoreTaskDto", listOutStoreTaskDto);
		request.getRequestDispatcher("/kc/kc_execchuku.jsp").forward(request, response);
	}
}
