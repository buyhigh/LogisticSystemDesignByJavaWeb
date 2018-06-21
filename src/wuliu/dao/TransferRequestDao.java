package wuliu.dao;

import java.util.List;

import wuliu.dto.TransferRequestDto;
import wuliu.entity.TransferRequest;

public interface TransferRequestDao {
	/**
	 * 增加运输请求单
	 * @param tfr
	 */
	void addTransferRequest(TransferRequest tfr);
	
	/**
	 * 获取指定状态的运输请求单
	 * @param state
	 * @return
	 */
	List<TransferRequestDto> getTransferRequestByState(int state);
	/**
	 * 获取第pageNum页的根据状态获取的运输请求单
	 * @param state
	 * @param pageNum
	 * @return
	 */
	List<TransferRequestDto> getTransferRequestByState(int state,int pageNum);
	
	/**
	 * 获取指定状态的运输请求单的数量
	 * @param state
	 * @return
	 */
	int getTransferRequestByStateCount(int state);
	
	/**
	 * 根据ID获取运输请求单
	 * @param transferrequest
	 * @return
	 */
	TransferRequestDto getTransferRequestById(int transferrequest);
	
	/**
	 * 修改指定运输请求单的状态为指定状态
	 * @param transferrequest
	 * @param state
	 */
	void updateTransferRequestDto(int transferrequest,int state);
	
	
}
