package wuliu.dto;

import wuliu.entity.OutStoreTask;

public class OutStoreTaskDto extends OutStoreTask {
	private String orderDate;//下单时间
	private String stateStr;//单据状态
	private String storeStr;//从哪个仓库出库
	private String goodName;//要出库的商品名称
	private int goodQuantity;//要出库商品的数量
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	public String getStoreStr() {
		return storeStr;
	}
	public void setStoreStr(String storeStr) {
		this.storeStr = storeStr;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getGoodQuantity() {
		return goodQuantity;
	}
	public void setGoodQuantity(int goodQuantity) {
		this.goodQuantity = goodQuantity;
	}
	
}
