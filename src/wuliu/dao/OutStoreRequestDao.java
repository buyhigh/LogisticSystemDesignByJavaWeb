package wuliu.dao;

import java.util.List;

import wuliu.dto.OutStoreRequestDto;
import wuliu.entity.OutStoreRequest;

public interface OutStoreRequestDao {
	/**
	 * 增加出库请求单
	 * @param osr
	 */
	void addOutStoreRequest(OutStoreRequest osr);
	
	
	/**
	 * 根据状态获取出库请求单
	 * @param state
	 * @return
	 */
	List<OutStoreRequestDto> getOutStoreRequestByState(int state);
	/**
	 * 获取第pageNum页的根据状态获取的出库请求单
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<OutStoreRequestDto> getOutStoreRequestByState(int state,int pageNum);
	/**
	 * 根据状态获取的出库请求单的数量
	 * @param state
	 * @return
	 */
	int getOutStoreRequestByStateCount(int state);
	
	/**
	 * 出库请求单状态为指定状态
	 * @param outstorerequest
	 * @param newState
	 */
	void updateOutStoreRequestState(int outstorerequest,int newState);
	
	
	/**
	 * 根据ID获取指定的出库请求单
	 * @param outstorerequest
	 * @return
	 */
	OutStoreRequestDto getgetOutStoreRequestById(int outstorerequest);
	
}
