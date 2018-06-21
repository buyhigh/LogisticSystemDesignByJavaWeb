package wuliu.dto;

import wuliu.entity.InStoreRequest;

public class InStoreRequestDto extends InStoreRequest {
	private String orderDate;//下单时间
	private String stateStr;//单据状态
	private String storeStr;//入哪个仓库
	private String goodName;//要入库的商品名称
	
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
	
}
