package wuliu.dao;

import java.util.List;

import wuliu.entity.TransferModel;

public interface TransferModelDao {
	/**
	 * �õ����еĳ�����Ϣ
	 * @return
	 */
	List<TransferModel> getAllTransferModel();
	
	/**
	 * ����ָ��ID��ȡ������Ϣ
	 * @return
	 */
	TransferModel getTransferModelById(int transferModel);
}
