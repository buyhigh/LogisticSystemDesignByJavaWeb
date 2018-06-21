package wuliu.dao;

import java.util.List;

import wuliu.entity.Store;

public interface StoreDao {
	/**
	 * 根据仓库ID得到仓库
	 * @param storeId
	 * @return
	 */
	Store getStoreByStoreId(int storeId);
	
	/**
	 * 根据仓库名得到仓库
	 * @param storeName
	 * @return
	 */
	Store getStoreByName(String storeName);
	
	/**
	 * 得到所有的仓库
	 * @return
	 */
	List<Store> getAllStore();
	
	
}
