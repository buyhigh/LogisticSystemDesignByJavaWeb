package wuliu.dao;

import java.util.List;

import wuliu.entity.Store;

public interface StoreDao {
	/**
	 * ���ݲֿ�ID�õ��ֿ�
	 * @param storeId
	 * @return
	 */
	Store getStoreByStoreId(int storeId);
	
	/**
	 * ���ݲֿ����õ��ֿ�
	 * @param storeName
	 * @return
	 */
	Store getStoreByName(String storeName);
	
	/**
	 * �õ����еĲֿ�
	 * @return
	 */
	List<Store> getAllStore();
	
	
}
