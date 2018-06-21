package wuliu.dao;

import java.util.List;

import wuliu.dto.OutStoreTaskDto;
import wuliu.entity.OutStoreTask;

public interface OutStoreTaskDao {
	/**
	 * 增加出库任务单
	 * @param ost
	 */
	void addOutStoreTask(OutStoreTask ost);
	
	
	/**
	 * 根据状态获取出库任务单
	 * @param state
	 * @return
	 */
	List<OutStoreTaskDto> getOutStoreTaskDtoByState(int state);
	
	
	/**
	 * 获取第pageNum的出库任务单
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<OutStoreTaskDto> getOutStoreTaskDtoByState(int state,int pageNum);
	
	
	/**
	 * 获取指定状态的出库任务单的数量
	 * @param state
	 * @return
	 */
	int getOutStoreTaskDtoByStateCount(int state);
	
	/**
	 * 修改指定配送通知单的状态
	 * @param outstoretask
	 * @param state
	 */
	void updateOutStoreTaskState(int outstoretask,int state);
	
	
	/**
	 * 根据ID获取出库任务单
	 * @param outstoretask
	 * @return
	 */
	OutStoreTaskDto getOutStoreTaskDtoById(int outstoretask);
	/**
	 * 根据ID获取出库任务单
	 * @param outstoretask
	 * @return
	 */
	int getDispatchIdByOutStoreTaskId(int outstoretask);
}
