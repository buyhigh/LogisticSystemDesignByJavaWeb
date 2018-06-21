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
import wuliu.dto.SendTraTaskDto;
import wuliu.entity.CarTime;
import wuliu.entity.Driver;
import wuliu.entity.SendCar;

public class SendZPServlet extends HttpServlet {

	private static final long serialVersionUID = 3696061813624635014L;
	private SendTraTaskDao sendTraTaskDao = new SendTraTaskDaoImpl();
	private DriverDao driverDao = new DriverDaoImpl();
	private SendCarDao sendCarDao = new SendCarDaoImpl();
	private TransferToolDao transferToolDao = new TransferToolDaoImpl();
	private CarTimeDao carTimeDao = new CarTimeDaoImpl();
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		
		//获取"已审核未执行"的派车任务单
		List<SendTraTaskDto> listSendTraTaskDto = sendTraTaskDao.getSendTraTaskDtoByState(2);
		//获取所有空闲的司机
		List<Driver> listDriver = driverDao.getDriverByState(1);
		int index = 0;
		for(int i = 0 ; i < listSendTraTaskDto.size() ; i++){
			//根据派车任务单的信息指派司机并生成派车单
			SendCar sendCar = null;
			SendTraTaskDto sendTraTaskDto = listSendTraTaskDto.get(i);
			for(int j =0 ; j < sendTraTaskDto.getRequestNum() ; j++){
				//有多少辆车的需求就需要生成多少派车单，并给每辆车指派一名空闲司机
				sendCar = new SendCar();
				if(index < listDriver.size()){
					//增加派车单
					sendCar.setDriverName(listDriver.get(index).getDriverName());
					sendCar.setTransferName(sendTraTaskDto.getTransferToolStr());
					sendCar.setSendTraTaskId(sendTraTaskDto.getSendTraTaskId());
					sendCar.setDriverId(listDriver.get(index).getDriverId());
					sendCar.setState(2);
					sendCarDao.addSendCar(sendCar);
					//改变司机的状态为"在途"
					driverDao.updateDriverState(listDriver.get(index).getDriverId(),2);
					//改变相应汽车的状态为"在途"
					transferToolDao.updateTransferToolState(sendTraTaskDto.getTransferToolId(), 2);
					//插入车次信息
					CarTime ct = new CarTime();
					ct.setDriverId(listDriver.get(index).getDriverId());
					ct.setTransferToolId(sendTraTaskDto.getTransferToolId());
					carTimeDao.addCarTime(ct);
					//设置派车任务单状态为已执行
					sendTraTaskDao.updateSendTraTaskState(sendTraTaskDto.getSendTraTaskId(),5);
					index++;
				}else{
					//已经无空闲司机可配，不生成派车单
				}
			}
		}
		int pageNum = 1;//当前页码
		int maxPageNum = 1;//总页数
		int totalCount = 0;//总的记录数
		
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
		request.getRequestDispatcher("/tra/tra_sendzp.jsp").forward(request, response);
	}
}
