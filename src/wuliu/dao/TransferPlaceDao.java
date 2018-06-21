package wuliu.dao;

import java.util.List;

import wuliu.entity.TransferPlace;

public interface TransferPlaceDao {
	/**
	 * 获取所有运输点信息
	 * @return
	 */
	List<TransferPlace> getAllTransferPlace();
}
