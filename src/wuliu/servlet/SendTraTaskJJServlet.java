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
		int pageNum = 1;//��ǰҳ��
		int maxPageNum = 1;//��ҳ��
		int totalCount = 0;//�ܵļ�¼��
		
		
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
		SendCarDto sendCarDto = null;//��ʾ��ѯĳ��˾�����ɳ���
		List<SendCarDto> listSendCarDto = null;//��ʾ��ѯ���е��ɳ���
		if(flag.equals("1")){
			//��ѯ����
			String driverIdStr = request.getParameter("txtDriverId");
			if(driverIdStr != null && !driverIdStr.equals("")){
				int driverId = Integer.parseInt(driverIdStr);
				sendCarDto = sendCarDao.getSendCarByDriverId(driverId);
			}else{
				listSendCarDto = sendCarDao.getSendCar(1);
			}
			request.setAttribute("curDriverId", driverIdStr);
		}else if(flag.equals("2")){
			//�ύ����
			String curDriverId = request.getParameter("curDriverId");
			if(curDriverId != null && !curDriverId.equals("")){
				//��ʾֻ����ĳ����ѯ�û����ɳ�����
				//��ȡ��˾�����ɳ���
				sendCarDto = sendCarDao.getSendCarByDriverId(Integer.parseInt(curDriverId));
				//��ȡ��˾�����ɳ�����Ӧ���ɳ�����
				SendTraTask stt = sendTraTaskDao.getSendTraTaskDtoById(sendCarDto.getSendTraTaskId()); 
				
				//�ָ�����
				transferToolDao.updateTransferToolQuantity(stt.getTransferToolId(),-1);
				//�ı��ɳ�����״̬Ϊ"ִ�����6"
				sendCarDao.updateSendCarState(Integer.parseInt(curDriverId),6);
				//��ȡ��Ӧ��˾�����Ļ�����״̬Ϊ"����1"
				driverDao.updateDriverState(Integer.parseInt(curDriverId),1);
				//��ȡ��Ӧ�ĳ������Ļس�����״̬Ϊ"����1"
				TransferTool tt = transferToolDao.getTransferToolById(stt.getTransferToolId());
				transferToolDao.updateTransferToolState(tt.getTransferId(), 1);
				//ɾ����˾����Ӧ�ɳ����ĳ�����Ϣ
				carTimeDao.deleteCarTime(Integer.parseInt(curDriverId), tt.getTransferId());
				
				//��ȡ���ɳ�����Ӧ���ɳ������µ������ɳ���������״̬��飬������е��ɳ�����״̬��Ϊ"ִ�����6"
				//��ı��ɳ����񵥵�״̬Ϊ"ִ�����6"
				List<SendCarDto> listSendCarDto2 = sendCarDao.getSendCarBySendTraId(sendCarDto.getSendTraTaskId());
				int i = 0 ;
				for(; i < listSendCarDto2.size() ; i++){
					if(listSendCarDto2.get(i).getState() != 6){
						break;
					}
				}
				if(i == listSendCarDto2.size()){
					//��ȡ��Ӧ���ɳ����񵥣�����״̬Ϊִ�����
					sendTraTaskDao.updateSendTraTaskState(sendCarDto.getSendTraTaskId(), 6);
				}
			}else{
				String[] idList = request.getParameterValues("chkItem");
				if(idList != null){
					//��ʾ������ѡ���˾���ɳ���
					for(int i = 0 ; i < idList.length ; i++){
						int driverId = Integer.parseInt(idList[i]);
						//��ȡ��˾�����ɳ���
						sendCarDto = sendCarDao.getSendCarByDriverId(driverId);
						//��ȡ��˾�����ɳ�����Ӧ���ɳ�����
						SendTraTask stt = sendTraTaskDao.getSendTraTaskDtoById(sendCarDto.getSendTraTaskId()); 
						
						//�ָ�����
						transferToolDao.updateTransferToolQuantity(stt.getTransferToolId(),-1);
						//�ı��ɳ�����״̬Ϊ"ִ�����6"
						sendCarDao.updateSendCarState(driverId,6);
						//�ı�˾����״̬Ϊ"����1"
						driverDao.updateDriverState(driverId,1);
						//��ȡ��Ӧ�ĳ������Ļس�����״̬Ϊ"����1"
						TransferTool tt = transferToolDao.getTransferToolById(stt.getTransferToolId());
						transferToolDao.updateTransferToolState(tt.getTransferId(), 1);
						//ɾ����˾����Ӧ�ɳ����ĳ�����Ϣ
						carTimeDao.deleteCarTime(driverId, tt.getTransferId());
						
						//��ȡ���ɳ�����Ӧ���ɳ������µ������ɳ���������״̬��飬������е��ɳ�����״̬��Ϊ"ִ�����6"
						//��ı��ɳ����񵥵�״̬Ϊ"ִ�����6"
						List<SendCarDto> listSendCarDto2 = sendCarDao.getSendCarBySendTraId(sendCarDto.getSendTraTaskId());
						int p = 0 ;
						for(; p < listSendCarDto2.size() ; p++){
							if(listSendCarDto2.get(p).getState() != 6){
								break;
							}
						}
						if(p == listSendCarDto2.size()){
							//��ȡ��Ӧ���ɳ����񵥣�����״̬Ϊִ�����
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
