package wuliu.dto;

import wuliu.entity.InStoreRequest;

public class InStoreRequestDto extends InStoreRequest {
	private String orderDate;//�µ�ʱ��
	private String stateStr;//����״̬
	private String storeStr;//���ĸ��ֿ�
	private String goodName;//Ҫ������Ʒ����
	
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
