package wuliu.entity;

public class InStoreRequest {
	private int inStoreRequestId;
	private int goodsId;
	private String inDate;
	private int storeId;
	private int stateId;
	private int goodQuantity;//要入库商品的数量
	public InStoreRequest() {}

	public InStoreRequest(int inStoreRequestId, int goodsId, String inDate) {
		this.inStoreRequestId = inStoreRequestId;
		this.goodsId = goodsId;
		this.inDate = inDate;
	}

	public int getInStoreRequestId() {
		return inStoreRequestId;
	}

	public void setInStoreRequestId(int inStoreRequestId) {
		this.inStoreRequestId = inStoreRequestId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getGoodQuantity() {
		return goodQuantity;
	}

	public void setGoodQuantity(int goodQuantity) {
		this.goodQuantity = goodQuantity;
	}
	
	
	
}
