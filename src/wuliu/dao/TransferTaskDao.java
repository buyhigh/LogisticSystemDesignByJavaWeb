package wuliu.dao;

import java.util.List;

import wuliu.dto.TransferTaskDto;
import wuliu.entity.TransferTask;

public interface TransferTaskDao {
	/**
	 * 增加运输任务单
	 * @param tt
	 */
	void addTransferTask(TransferTask tt);
	
	/**
	 * 根据状态获取运输任务单
	 * @param state
	 * @return
	 */
	List<TransferTaskDto> getTransferTaskDtoByState(int state);
	
	
	/**
	 * 获取第pageNum页的运输任务单
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<TransferTaskDto> getTransferTaskDtoByState(int state,int pageNum);
	
	
	/**
	 * 获取指定状态的运输任务单的数量
	 * @param state
	 * @return
	 */
	int getTransferTaskDtoByStateCount(int state);
	
	/**
	 * 根据ID获取运输任务单
	 * @param transferTask
	 * @return
	 */
	TransferTaskDto getTransferTaskDtoById(int transferTask);
	
	/**
	 * 修改运输任务单的状态
	 * @param state
	 */
	void updateTransferTaskState(int transferTask,int state);
}
