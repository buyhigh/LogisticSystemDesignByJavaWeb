package wuliu.dto;

import wuliu.entity.OutStoreTask;

public class OutStoreTaskDto extends OutStoreTask {
	private String orderDate;//�µ�ʱ��
	private String stateStr;//����״̬
	private String storeStr;//���ĸ��ֿ����
	private String goodName;//Ҫ�������Ʒ����
	private int goodQuantity;//Ҫ������Ʒ������
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
