package wuliu.entity;

public class Dispatch {
	private int dispatchId;
	private String orderId;
	private String goodName;
	private int goodQuantity;
	private int transferTool;
	private String orderDate;
	private String sendName;
	private String sendTel;
	private String receiverName;
	private String receiverTel;
	private String receiverProvince;
	private String receiverCity;
	private String receiverStreet;
	private String Creater;
	private int state;
	
	public Dispatch() {
	}

	public Dispatch(int dispatchId, String orderId, String goodName,
			int goodQuantity, int transferTool, String orderDate,
			String sendName, String sendTel, String receiverName,
			String receiverTel, String receiverProvince, String receiverCity,
			String receiverStreet, int state) {
		this.dispatchId = dispatchId;
		this.orderId = orderId;
		this.goodName = goodName;
		this.goodQuantity = goodQuantity;
		this.transferTool = transferTool;
		this.orderDate = orderDate;
		this.sendName = sendName;
		this.sendTel = sendTel;
		this.receiverName = receiverName;
		this.receiverTel = receiverTel;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.receiverStreet = receiverStreet;
		this.state = state;
	}
	
	public Dispatch(int dispatchId, String orderId, String goodName,
			int goodQuantity, int transferTool, String orderDate,
			String sendName, String sendTel, String receiverName,
			String receiverTel, String receiverProvince, String receiverCity,
			String receiverStreet, int state,String Creater) {
		this.dispatchId = dispatchId;
		this.orderId = orderId;
		this.goodName = goodName;
		this.goodQuantity = goodQuantity;
		this.transferTool = transferTool;
		this.orderDate = orderDate;
		this.sendName = sendName;
		this.sendTel = sendTel;
		this.receiverName = receiverName;
		this.receiverTel = receiverTel;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.receiverStreet = receiverStreet;
		this.state = state;
		this.Creater = Creater;
	}
	
	public int getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public int getTransferTool() {
		return transferTool;
	}

	public void setTransferTool(int transferTool) {
		this.transferTool = transferTool;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendTel() {
		return sendTel;
	}

	public void setSendTel(String sendTel) {
		this.sendTel = sendTel;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverTel() {
		return receiverTel;
	}

	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}

	public String getReceiverProvince() {
		return receiverProvince;
	}

	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverStreet() {
		return receiverStreet;
	}

	public void setReceiverStreet(String receiverStreet) {
		this.receiverStreet = receiverStreet;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	public String getCreater() {
		return Creater;
	}

	public void setCreater(String Creater) {
		this.Creater = Creater;
	}
	
}
