package wuliu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wuliu.dao.CarTimeDao;
import wuliu.dao.DriverDao;
import wuliu.dao.SendCarDao;
import wuliu.dao.SendTraTaskDao;
import wuliu.dao.TransferToolDao;
import wuliu.dao.impl.CarTimeDaoImpl;
import wuliu.dao.impl.DriverDaoImpl;
import wuliu.dao.impl.SendCarDaoImpl;
import wuliu.dao.impl.SendTraTaskDaoImpl;
import wuliu.dao.impl.TransferToolDaoImpl;
import wuliu.dto.SendCarDto;
import wuliu.entity.SendTraTask;
import wuliu.entity.TransferTool;

public class SendTraTaskJJServlet extends HttpServlet {

	private static final long serialVersionUID = -1766834172500617022L;
	private SendCarDao sendCarDao = new SendCarDaoImpl();
	private DriverDao driverDao = new DriverDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	private SendTraTaskDao sendTraTaskDao = new SendTraTaskDaoImpl();
	private CarTimeDao carTimeDao = new CarTimeDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
		
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr != null && !pageNumStr.equals("")){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		
		
		List<SendCarDto> listSendCarDto = sendCarDao.getSendCar(pageNum);
		totalCount = sendCarDao.getSendCarCount();
		if(totalCount % 10 == 0){
			maxPageNum = totalCount / 10;
		}else{
			maxPageNum = totalCount / 10 + 1;
		}
		
		request.setAttribute("curPage",pageNum);
		request.setAttribute("maxPage", maxPageNum);
		request.setAttribute("count", totalCount);
		request.setAttribute("listSendCarDto", listSendCarDto);
		
		request.getRequestDispatcher("/tra/tra_sendjj.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		String flag = request.getParameter("flag");
		SendCarDto sendCarDto = null;//表示查询某个司机的派车单
		List<SendCarDto> listSendCarDto = null;//表示查询所有的派车单
		if(flag.equals("1")){
			//查询操作
			String driverIdStr = request.getParameter("txtDriverId");
			if(driverIdStr != null && !driverIdStr.equals("")){
				int driverId = Integer.parseInt(driverIdStr);
				sendCarDto = sendCarDao.getSendCarByDriverId(driverId);
			}else{
				listSendCarDto = sendCarDao.getSendCar(1);
			}
			request.setAttribute("curDriverId", driverIdStr);
		}else if(flag.equals("2")){
			//提交操作
			String curDriverId = request.getParameter("curDriverId");
			if(curDriverId != null && !curDriverId.equals("")){
				//表示只交接某个查询用户的派车任务
				//获取该司机的派车单
				sendCarDto = sendCarDao.getSendCarByDriverId(Integer.parseInt(curDriverId));
				//获取该司机的派车单对应的派车任务单
				SendTraTask stt = sendTraTaskDao.getSendTraTaskDtoById(sendCarDto.getSendTraTaskId()); 
				
				//恢复运力
				transferToolDao.updateTransferToolQuantity(stt.getTransferToolId(),-1);
				//改变派车单的状态为"执行完成6"
				sendCarDao.updateSendCarState(Integer.parseInt(curDriverId),6);
				//获取相应的司机并改回他的状态为"空闲1"
				driverDao.updateDriverState(Integer.parseInt(curDriverId),1);
				//获取相应的车辆并改回车辆的状态为"空闲1"
				TransferTool tt = transferToolDao.getTransferToolById(stt.getTransferToolId());
				transferToolDao.updateTransferToolState(tt.getTransferId(), 1);
				//删除该司机对应派车单的车次信息
				carTimeDao.deleteCarTime(Integer.parseInt(curDriverId), tt.getTransferId());
				
				//获取该派车单对应的派车任务单下的所有派车单，进行状态检查，如果所有的派车单的状态都为"执行完成6"
				//则改变派车任务单的状态为"执行完成6"
				List<SendCarDto> listSendCarDto2 = sendCarDao.getSendCarBySendTraId(sendCarDto.getSendTraTaskId());
				int i = 0 ;
				for(; i < listSendCarDto2.size() ; i++){
					if(listSendCarDto2.get(i).getState() != 6){
						break;
					}
				}
				if(i == listSendCarDto2.size()){
					//获取对应的派车任务单，设置状态为执行完成
					sendTraTaskDao.updateSendTraTaskState(sendCarDto.getSendTraTaskId(), 6);
				}
			}else{
				String[] idList = request.getParameterValues("chkItem");
				if(idList != null){
					//表示交接所选择的司机派车单
					for(int i = 0 ; i < idList.length ; i++){
						int driverId = Integer.parseInt(idList[i]);
						//获取该司机的派车单
						sendCarDto = sendCarDao.getSendCarByDriverId(driverId);
						//获取该司机的派车单对应的派车任务单
						SendTraTask stt = sendTraTaskDao.getSendTraTaskDtoById(sendCarDto.getSendTraTaskId()); 
						
						//恢复运力
						transferToolDao.updateTransferToolQuantity(stt.getTransferToolId(),-1);
						//改变派车单的状态为"执行完成6"
						sendCarDao.updateSendCarState(driverId,6);
						//改变司机的状态为"空闲1"
						driverDao.updateDriverState(driverId,1);
						//获取相应的车辆并改回车辆的状态为"空闲1"
						TransferTool tt = transferToolDao.getTransferToolById(stt.getTransferToolId());
						transferToolDao.updateTransferToolState(tt.getTransferId(), 1);
						//删除该司机对应派车单的车次信息
						carTimeDao.deleteCarTime(driverId, tt.getTransferId());
						
						//获取该派车单对应的派车任务单下的所有派车单，进行状态检查，如果所有的派车单的状态都为"执行完成6"
						//则改变派车任务单的状态为"执行完成6"
						List<SendCarDto> listSendCarDto2 = sendCarDao.getSendCarBySendTraId(sendCarDto.getSendTraTaskId());
						int p = 0 ;
						for(; p < listSendCarDto2.size() ; p++){
							if(listSendCarDto2.get(p).getState() != 6){
								break;
							}
						}
						if(p == listSendCarDto2.size()){
							//获取对应的派车任务单，设置状态为执行完成
							sendTraTaskDao.updateSendTraTaskState(sendCarDto.getSendTraTaskId(), 6);
						}
					}
				}
				listSendCarDto = sendCarDao.getSendCar(1);
				sendCarDto = null;
			}
			request.setAttribute("curDriverId", curDriverId);
		}
		
		
		request.setAttribute("listSendCarDto", listSendCarDto);
		request.setAttribute("sendCarDto", sendCarDto);
		request.getRequestDispatcher("/tra/tra_sendjj.jsp").forward(request, response);
		
	}

}
