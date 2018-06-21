package wuliu.entity;

public class StoreRefGood {
	private int storeId;
	private int goodsId;
	private int num;
	
	public StoreRefGood() {}

	public StoreRefGood(int storeId, int goodsId, int num) {
		this.storeId = storeId;
		this.goodsId = goodsId;
		this.num = num;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}
