package wuliu.dto;

import wuliu.entity.TransferRequest;

public class TransferRequestDto extends TransferRequest {
	private String transferName;//���������
	private String transferModel;//������������
	private String transferTool;//��������
	private int transferQuantity;//��������
	private String orderDate;//�µ�ʱ��
	private String stateName;//״̬����
	public String getTransferName() {
		return transferName;
	}
	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}
	public String getTransferModel() {
		return transferModel;
	}
	public void setTransferModel(String transferModel) {
		this.transferModel = transferModel;
	}
	public String getTransferTool() {
		return transferTool;
	}
	public void setTransferTool(String transferTool) {
		this.transferTool = transferTool;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getTransferQuantity() {
		return transferQuantity;
	}
	public void setTransferQuantity(int transferQuantity) {
		this.transferQuantity = transferQuantity;
	}
	
}
