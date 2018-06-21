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
	//private StateDao stateDao = new StateDaoImpl();//��©�����������ӽ�����ӿڣ�ʵ���������ʵ�ַ����ϵ�
	private SaveDivStoreDao saveDivStoreDao = new SaveDivStoreDaoImpl();//��©�����������ӽ�����ӿڣ�ʵ���������ʵ�ַ����ϵ�
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
		
		//ֻ�ǲ��Խӿ�
		//int tempid = saveDivStoreDao.getDivStoreIdByOutStoreTask(11);
		//System.out.println(tempid);
		
		dispatchDao.updateDispatchState(Dispatchid,1);//���ڲ������������������ע�ͱ���
		
		//������֮��Ҫ��ʾʣ�µ�δ����ĵ�
		List<SaveDivStore> listsaveDivStore = saveDivStoreDao.getSaveDivStoreBystate(1);
		request.setAttribute("listsaveDivStore", listsaveDivStore);
		request.getRequestDispatcher("/kc/kc_daiyunkuncunchuhuoqueren.jsp").forward(request, response);
	}

}
