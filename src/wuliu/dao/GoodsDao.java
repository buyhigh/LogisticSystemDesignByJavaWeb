package wuliu.dao;

import java.util.List;

import wuliu.dto.GoodsDto;
import wuliu.entity.Goods;



public interface GoodsDao {
	/**
	 * 根据商品ID获取商品
	 * @param GoodId
	 * @return
	 */
	GoodsDto getGoodByGoodId(int goodId);
	
	/**
	 * 根据商品的名称获取商品
	 * @param goodName
	 * @return
	 */
	List<GoodsDto> getGoodByGoodName(String goodName);
	/**
	 *获取指定仓库的所有商品（包括商品数量）
	 * @param storeId
	 * @return
	 */
	List<GoodsDto> getGoodsByStoreId(int storeId);
	
	/**
	 * 获取第pageNum页商品
	 * @param storeId
	 * @param pageNum
	 * @return
	 */
	List<GoodsDto> getGoodsByStoreId(int storeId,int pageNum);
	
	/**
	 * 获取指定仓库指定商品的信息
	 * @param storeId
	 * @param goodId
	 * @return
	 */
	GoodsDto getGoods(int storeId,int goodId);
	
	/**
	 * 获取指定仓库下的商品数量
	 * @param storeId
	 * @return
	 */
	int getGoodsNumByStoreId(int storeId);
	
	/**
	 * 新增产品,返回数据库中新增产品的ID
	 * @param good
	 */
	int addGoods(Goods good);
	/**
	 * 新增产品,返回数据库中新增产品的ID
	 * @param good
	 */
	int getGoodsIdByGoodsName(String good);
}
