package wuliu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wuliu.dao.DispUserDao;
import wuliu.dao.TraDao;
import wuliu.dao.TransferTaskDao;
import wuliu.dao.FinConfirmDao;
import wuliu.dao.impl.DispUserDaoImpl;
import wuliu.dao.impl.TraDaoImpl;
import wuliu.dao.impl.TransferTaskDaoImpl;
import wuliu.dao.impl.FinConfirmDaoImpl;
import wuliu.dto.TraDto;
import wuliu.dto.TransferTaskDto;
import wuliu.entity.DispUser;
import wuliu.entity.FinConfirm;
import wuliu.entity.User;

import wuliu.entity.User;
import wuliu.dao.impl.UserDaoImpl;
import wuliu.dao.UserDao;

public class TraJJServlet extends HttpServlet {

	private static final long serialVersionUID = 3876784238647681482L;
	private TransferTaskDao transferTaskDao = new TransferTaskDaoImpl();
	private TraDao traDao = new TraDaoImpl();
	private DispUserDao dispUserDao = new DispUserDaoImpl();
	private FinConfirmDao finConfirmDao = new FinConfirmDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		List<TransferTaskDto> listTransferTaskDto = transferTaskDao.getTransferTaskDtoByState(5);
		request.setAttribute("listTransferTaskDto", listTransferTaskDto);
		request.getRequestDispatcher("/tra/tra_trajj.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		HttpSession session = request.getSession();
		String loginUser =((User) session.getAttribute("loginUser")).getUserName();
		System.out.println(loginUser+"debug1");
		String flag = request.getParameter("flag");
		int dispUserId = -1;
		String dispUserIdStr = null;
		List<TraDto> listTraDto = null;
		List<TransferTaskDto> listTransferTaskDto = null;
		if(flag.equals("1")){
			//表示查询操作
			dispUserIdStr = request.getParameter("dispUserId");
			if(dispUserIdStr != null && !dispUserIdStr.equals("")){
				dispUserId = Integer.parseInt(dispUserIdStr);
			}
			if(dispUserId != -1){
				listTraDto = traDao.getTraByDispUserId(dispUserId);
				listTransferTaskDto = new ArrayList<TransferTaskDto>();
				for(int i =  0 ; i < listTraDto.size() ; i++){
					listTransferTaskDto.add(transferTaskDao.getTransferTaskDtoById(listTraDto.get(i).getTransferTaskId()));
				}
			}
		}else if(flag.equals("2")){
			//表示提交操作
			dispUserIdStr = request.getParameter("curDispUserId");
			if(dispUserIdStr != null && !dispUserIdStr.equals("")){
				dispUserId = Integer.parseInt(dispUserIdStr);
			}
			String[] idList = request.getParameterValues("chkItem");
			listTransferTaskDto = new ArrayList<TransferTaskDto>();
			if(dispUserId != -1){
				System.out.println("debug1");
				listTraDto = traDao.getTraByDispUserId(dispUserId);
				for(int i = 0 ; i < idList.length ; i++){
					//判断该配送员配送的每一个运输任务单是否是所选择的
					//如果是，则表示运输交接，需要改变相应运输任务单的
					//状态为"执行完成"，并修改该配送员的配送额增1
					TraDto td = null;
					for(int j = 0 ; j < listTraDto.size() ; j++){
						System.out.println("debug2");
						td = listTraDto.get(j);
						int transferTask = td.getTransferTaskId();
						if(transferTask == Integer.parseInt(idList[i])){
							System.out.println("debug3");
							transferTaskDao.updateTransferTaskState(transferTask, 6);
							//生成最终确认单
							int dispatchid = finConfirmDao.getDispatchIdByTrataskid(transferTask);
							String consumer = finConfirmDao.getConsumerByTrataskid(transferTask);
							finConfirmDao.addFinConfirm(dispatchid, transferTask, 1, consumer, loginUser);
							
							DispUser dispUser = dispUserDao.getDispUserById(td.getDispUserId());
							int newNum = dispUser.getDispNum() - 1;
							dispUserDao.updateDispUserNum(dispUser.getDispUserId(), newNum);
							break;
						}
						if(i == 0){
							System.out.println("debug4");
							listTransferTaskDto.add(transferTaskDao.getTransferTaskDtoById(td.getTransferTaskId()));
						}
					}
				}
			}else{
				for(int i = 0 ; i < idList.length ; i++){
					int transferTask = Integer.parseInt(idList[i]);
					transferTaskDao.updateTransferTaskState(transferTask, 6);
					TraDto td = traDao.getTraByTransferTaskId(transferTask);
					DispUser dispUser = dispUserDao.getDispUserById(td.getDispUserId());
					int newNum = dispUser.getDispNum() - 1;
					dispUserDao.updateDispUserNum(dispUser.getDispUserId(), newNum);
					listTransferTaskDto.add(transferTaskDao.getTransferTaskDtoById(td.getTransferTaskId()));
					//添加最终确认单
					int dispatchid = finConfirmDao.getDispatchIdByTrataskid(transferTask);
					String consumer = finConfirmDao.getConsumerByTrataskid(transferTask);
					finConfirmDao.addFinConfirm(dispatchid, transferTask, 1, consumer, loginUser);
				}
			}
		}
		
		request.setAttribute("listTransferTaskDto", listTransferTaskDto);
		request.setAttribute("curDispUserId", dispUserId);
		request.getRequestDispatcher("/tra/tra_trajj.jsp").forward(request, response);
	}
}
