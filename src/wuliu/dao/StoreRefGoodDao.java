package wuliu.dao;


import wuliu.entity.StoreRefGood;

public interface StoreRefGoodDao {
	/**
	 * 根据商品名称和数量获取商品库存信息
	 * @param goodName
	 * @param goodQuantity
	 * @return
	 */
	StoreRefGood examineDispatch(String goodName,int goodQuantity);
	
	
	/**
	 * 获取商品在指定仓库的库存信息
	 * @param store
	 * @param goodName
	 * @param goodQuantity
	 * @return
	 */
	StoreRefGood examineOutStoreRequest(int store,String goodName,int goodQuantity);
	
	/**
	 * 更新库存量
	 * @param store
	 * @param goodName
	 * @param goodQuantity
	 */
	void updateStoreGood(int store,String goodName,int goodQuantity);
	
	
	/**
	 * 增加商品库存信息
	 * @param srf
	 */
	void addStoreGood(StoreRefGood srf);
}
