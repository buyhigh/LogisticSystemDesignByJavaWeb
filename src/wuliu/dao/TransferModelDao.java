package wuliu.dao;

import java.util.List;

import wuliu.entity.TransferModel;

public interface TransferModelDao {
	/**
	 * 得到所有的车型信息
	 * @return
	 */
	List<TransferModel> getAllTransferModel();
	
	/**
	 * 根据指定ID获取车型信息
	 * @return
	 */
	TransferModel getTransferModelById(int transferModel);
}
