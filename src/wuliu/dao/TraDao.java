package wuliu.dao;

import java.util.List;

import wuliu.dto.TraDto;
import wuliu.entity.Tra;

public interface TraDao {
	/**
	 * 新增运输单
	 * @param t
	 */
	void addTra(Tra t);
	
	/**
	 * 根据配送员获取运输单
	 * @param dispuser
	 * @return
	 */
	List<TraDto> getTraByDispUserId(int dispuser);
	
	
	/**
	 * 获取第pageNum的运输单
	 * @param pageNum
	 * @return
	 */
	List<TraDto> getTraPage(int pageNum);
	
	
	/**
	 * 获取运输单的数量
	 * @return
	 */
	int getTraCount();
	
	
	/**
	 * 根据ID获取运输单
	 * @param traId
	 * @return
	 */
	TraDto getTraById(int traId);
	
	
	/**
	 * 根据运输任务单获取运输单
	 * @param transfertask
	 * @return
	 */
	TraDto getTraByTransferTaskId(int transfertask);
}
