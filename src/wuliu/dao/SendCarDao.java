package wuliu.dao;

import java.util.List;

import wuliu.dto.SendCarDto;
import wuliu.entity.SendCar;

public interface SendCarDao {
	/**
	 * �����ɳ���
	 * @param sc
	 */
	void addSendCar(SendCar sc);
	
	/**
	 * ��ȡ��pageNumҳ���ɳ���
	 * @param pageNum
	 * @return
	 */
	List<SendCarDto> getSendCar(int pageNum);
	
	/**
	 * ��ȡ�����ɳ���������
	 */
	int getSendCarCount();
	
	/**
	 * ��ȡ˾�����ɳ���
	 * @param driverId
	 * @return
	 */
	SendCarDto getSendCarByDriverId(int driverId);
	
	/**
	 * �ı�˾�����ɳ�����״̬
	 * @param driverId
	 * @param state
	 */
	void updateSendCarState(int driverId,int state);
	
	/**
	 * ����ָ���ɳ�����ID��ȡ�ɳ���
	 * @param sendTraId
	 * @return
	 */
	List<SendCarDto> getSendCarBySendTraId(int sendTraId);
	
}
