package wuliu.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import wuliu.entity.SaveDivStore;
import wuliu.dao.SaveDivStoreDao;
import wuliu.dao.impl.SaveDivStoreDaoImpl;
import wuliu.entity.Dispatch;
import wuliu.dao.DispatchDao;
import wuliu.dao.impl.DispatchDaoImpl;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExamineSaveDivStoreServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private StateDao stateDao = new StateDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	private SaveDivStoreDao saveDivStoreDao = new SaveDivStoreDaoImpl();//别漏掉这个，这个视将抽象接口，实例到具体的实现方法上的
	private DispatchDao dispatchDao = new DispatchDaoImpl();
	

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		//List<State> listState = stateDao.getAllState();
		List<SaveDivStore> listsaveDivStore = saveDivStoreDao.getSaveDivStoreBystate(1);
		request.setAttribute("listsaveDivStore", listsaveDivStore);
		request.getRequestDispatcher("/kc/kc_daiyunkuncunchuhuoqueren.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		System.out.println("ExamineSaveDivStoreServlet post");
		String id = request.getParameter("selectname");
		saveDivStoreDao.UpdateSaveDivStore(Integer.parseInt(id),2);
		
		String orderid = saveDivStoreDao.getDispatchIdById(Integer.parseInt(id));
		int Dispatchid = dispatchDao.getDispatchidByOrderid(orderid);
		
		//只是测试接口
		//int tempid = saveDivStoreDao.getDivStoreIdByOutStoreTask(11);
		//System.out.println(tempid);
		
		dispatchDao.updateDispatchState(Dispatchid,1);//处于测试其他单独库存借口先注释本句
		
		//处理完之后，要显示剩下的未处理的单
		List<SaveDivStore> listsaveDivStore = saveDivStoreDao.getSaveDivStoreBystate(1);
		request.setAttribute("listsaveDivStore", listsaveDivStore);
		request.getRequestDispatcher("/kc/kc_daiyunkuncunchuhuoqueren.jsp").forward(request, response);
	}

}
