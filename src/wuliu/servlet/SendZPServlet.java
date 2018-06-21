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
		
		//��ȡ"�����δִ��"���ɳ�����
		List<SendTraTaskDto> listSendTraTaskDto = sendTraTaskDao.getSendTraTaskDtoByState(2);
		//��ȡ���п��е�˾��
		List<Driver> listDriver = driverDao.getDriverByState(1);
		int index = 0;
		for(int i = 0 ; i < listSendTraTaskDto.size() ; i++){
			//�����ɳ����񵥵���Ϣָ��˾���������ɳ���
			SendCar sendCar = null;
			SendTraTaskDto sendTraTaskDto = listSendTraTaskDto.get(i);
			for(int j =0 ; j < sendTraTaskDto.getRequestNum() ; j++){
				//�ж����������������Ҫ���ɶ����ɳ���������ÿ����ָ��һ������˾��
				sendCar = new SendCar();
				if(index < listDriver.size()){
					//�����ɳ���
					sendCar.setDriverName(listDriver.get(index).getDriverName());
					sendCar.setTransferName(sendTraTaskDto.getTransferToolStr());
					sendCar.setSendTraTaskId(sendTraTaskDto.getSendTraTaskId());
					sendCar.setDriverId(listDriver.get(index).getDriverId());
					sendCar.setState(2);
					sendCarDao.addSendCar(sendCar);
					//�ı�˾����״̬Ϊ"��;"
					driverDao.updateDriverState(listDriver.get(index).getDriverId(),2);
					//�ı���Ӧ������״̬Ϊ"��;"
					transferToolDao.updateTransferToolState(sendTraTaskDto.getTransferToolId(), 2);
					//���복����Ϣ
					CarTime ct = new CarTime();
					ct.setDriverId(listDriver.get(index).getDriverId());
					ct.setTransferToolId(sendTraTaskDto.getTransferToolId());
					carTimeDao.addCarTime(ct);
					//�����ɳ�����״̬Ϊ��ִ��
					sendTraTaskDao.updateSendTraTaskState(sendTraTaskDto.getSendTraTaskId(),5);
					index++;
				}else{
					//�Ѿ��޿���˾�����䣬�������ɳ���
				}
			}
		}
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
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
