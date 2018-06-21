package wuliu.dto;

import wuliu.entity.TransferTask;

public class TransferTaskDto extends TransferTask {
	private String transferName;//运输点名称
	private String transferModel;//运力工具类型
	private String transferTool;//运力工具
	private int requestNum;//需求数量
	private int transferQuantity;//可用数量
	private String orderDate;//下单时间
	private String stateName;//状态名称
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
	public int getRequestNum() {
		return requestNum;
	}
	public void setRequestNum(int requestNum) {
		this.requestNum = requestNum;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getTransferQuantity() {
		return transferQuantity;
	}
	public void setTransferQuantity(int transferQuantity) {
		this.transferQuantity = transferQuantity;
	}
	
	
}
