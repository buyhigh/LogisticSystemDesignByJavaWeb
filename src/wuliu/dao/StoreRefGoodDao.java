package wuliu.dao;


import wuliu.entity.StoreRefGood;

public interface StoreRefGoodDao {
	/**
	 * ������Ʒ���ƺ�������ȡ��Ʒ�����Ϣ
	 * @param goodName
	 * @param goodQuantity
	 * @return
	 */
	StoreRefGood examineDispatch(String goodName,int goodQuantity);
	
	
	/**
	 * ��ȡ��Ʒ��ָ���ֿ�Ŀ����Ϣ
	 * @param store
	 * @param goodName
	 * @param goodQuantity
	 * @return
	 */
	StoreRefGood examineOutStoreRequest(int store,String goodName,int goodQuantity);
	
	/**
	 * ���¿����
	 * @param store
	 * @param goodName
	 * @param goodQuantity
	 */
	void updateStoreGood(int store,String goodName,int goodQuantity);
	
	
	/**
	 * ������Ʒ�����Ϣ
	 * @param srf
	 */
	void addStoreGood(StoreRefGood srf);
}
