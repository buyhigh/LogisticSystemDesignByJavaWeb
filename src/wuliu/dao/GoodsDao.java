package wuliu.dao;

import java.util.List;

import wuliu.dto.GoodsDto;
import wuliu.entity.Goods;



public interface GoodsDao {
	/**
	 * ������ƷID��ȡ��Ʒ
	 * @param GoodId
	 * @return
	 */
	GoodsDto getGoodByGoodId(int goodId);
	
	/**
	 * ������Ʒ�����ƻ�ȡ��Ʒ
	 * @param goodName
	 * @return
	 */
	List<GoodsDto> getGoodByGoodName(String goodName);
	/**
	 *��ȡָ���ֿ��������Ʒ��������Ʒ������
	 * @param storeId
	 * @return
	 */
	List<GoodsDto> getGoodsByStoreId(int storeId);
	
	/**
	 * ��ȡ��pageNumҳ��Ʒ
	 * @param storeId
	 * @param pageNum
	 * @return
	 */
	List<GoodsDto> getGoodsByStoreId(int storeId,int pageNum);
	
	/**
	 * ��ȡָ���ֿ�ָ����Ʒ����Ϣ
	 * @param storeId
	 * @param goodId
	 * @return
	 */
	GoodsDto getGoods(int storeId,int goodId);
	
	/**
	 * ��ȡָ���ֿ��µ���Ʒ����
	 * @param storeId
	 * @return
	 */
	int getGoodsNumByStoreId(int storeId);
	
	/**
	 * ������Ʒ,�������ݿ���������Ʒ��ID
	 * @param good
	 */
	int addGoods(Goods good);
	/**
	 * ������Ʒ,�������ݿ���������Ʒ��ID
	 * @param good
	 */
	int getGoodsIdByGoodsName(String good);
}
