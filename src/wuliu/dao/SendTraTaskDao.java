package wuliu.dao;

import java.util.List;

import wuliu.dto.SendTraTaskDto;
import wuliu.entity.SendTraTask;

public interface SendTraTaskDao {
	/**
	 * 增加派车任务单
	 * @param stt
	 */
	void addSendTraTask(SendTraTask stt);
	
	
	/**
	 * 根据状态获取派车任务单
	 * @param state
	 * @return
	 */
	List<SendTraTaskDto> getSendTraTaskDtoByState(int state);
	
	
	/**
	 * 获取第PageNum页的派车任务单
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<SendTraTaskDto> getSendTraTaskDtoByState(int state,int pageNum);
	
	/**
	 * 获取指定状态的派车任务单的数量
	 * @param state
	 * @return
	 */
	int getSendTraTaskCountByState(int state);
	
	/**
	 * 修改指定派车任务单为指定状态
	 * @param sendTraId
	 * @param state
	 */
	void updateSendTraTaskState(int sendTraId,int state);
	
	/**
	 * 根据ID获取派车任务单
	 * @param sendTraId
	 * @return
	 */
	SendTraTaskDto getSendTraTaskDtoById(int sendTraId);
	
	/**
	 * 获取对应运输请求单的派车任务单
	 * @param transferrequest
	 * @return
	 */
	SendTraTaskDto getSendTraTaskByTfq(int transferrequest);
	
}
