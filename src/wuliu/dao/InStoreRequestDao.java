package wuliu.dao;

import java.util.List;

import wuliu.dto.InStoreRequestDto;
import wuliu.entity.InStoreRequest;

public interface InStoreRequestDao {
	
	/**
	 * 根据ID获取入库请求单
	 * @param instorerequest
	 * @return
	 */
	InStoreRequestDto getInStoreRequestById(int instorerequest);
	
	
	/**
	 * 根据状态获取入库请求单
	 * @param state
	 * @return
	 */
	List<InStoreRequestDto> getInStoreRequestByState(int state);
	
	/**
	 * 获取第pageNum页的根据状态获取的入库请求单
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<InStoreRequestDto> getInStoreRequestByState(int state,int pageNum);
	
	/**
	 * 获取指定状态的入库请求单的数目
	 * @param state
	 * @return
	 */
	int getInStoreRequestByStateCount(int state);
	
	
	/**
	 * 修改入库请求单的状态为指定状态
	 * @param instorerequest
	 * @param state
	 */
	void updateInStoreRequestState(String[] idList,int state);
	
	
	/**
	 * 增加入库请求单
	 * @param isr
	 */
	void addInStoreRequest(InStoreRequest isr);
	
}
