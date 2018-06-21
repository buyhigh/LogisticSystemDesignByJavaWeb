package wuliu.dto;

import wuliu.entity.Goods;

public class GoodsDto extends Goods{
	private int storeId;
	private int num;
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
