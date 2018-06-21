package wuliu.dao;

import java.util.List;

import wuliu.dto.SendCarDto;
import wuliu.entity.SendCar;

public interface SendCarDao {
	/**
	 * 增加派车单
	 * @param sc
	 */
	void addSendCar(SendCar sc);
	
	/**
	 * 获取第pageNum页的派车单
	 * @param pageNum
	 * @return
	 */
	List<SendCarDto> getSendCar(int pageNum);
	
	/**
	 * 获取所有派车单的数量
	 */
	int getSendCarCount();
	
	/**
	 * 获取司机的派车单
	 * @param driverId
	 * @return
	 */
	SendCarDto getSendCarByDriverId(int driverId);
	
	/**
	 * 改变司机的派车单的状态
	 * @param driverId
	 * @param state
	 */
	void updateSendCarState(int driverId,int state);
	
	/**
	 * 根据指定派车任务单ID获取派车单
	 * @param sendTraId
	 * @return
	 */
	List<SendCarDto> getSendCarBySendTraId(int sendTraId);
	
}
