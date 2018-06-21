package wuliu.entity;

public class SendTraTask {
	private int sendTraTaskId;
	private int transferRequestId;
	private int transferPlaceId;
	private int transferModelId;
	private int transferToolId;
	private int requestNum;
	private int state;
	public SendTraTask(int sendTraTaskId, int transferRequestId,
			int transferPlaceId, int transferModelId, int transferToolId,
			int requestNum, int state) {
		this.sendTraTaskId = sendTraTaskId;
		this.transferRequestId = transferRequestId;
		this.transferPlaceId = transferPlaceId;
		this.transferModelId = transferModelId;
		this.transferToolId = transferToolId;
		this.requestNum = requestNum;
		this.state = state;
	}
	public SendTraTask() {
	}
	public int getSendTraTaskId() {
		return sendTraTaskId;
	}
	public void setSendTraTaskId(int sendTraTaskId) {
		this.sendTraTaskId = sendTraTaskId;
	}
	public int getTransferRequestId() {
		return transferRequestId;
	}
	public void setTransferRequestId(int transferRequestId) {
		this.transferRequestId = transferRequestId;
	}
	public int getTransferPlaceId() {
		return transferPlaceId;
	}
	public void setTransferPlaceId(int transferPlaceId) {
		this.transferPlaceId = transferPlaceId;
	}
	public int getTransferModelId() {
		return transferModelId;
	}
	public void setTransferModelId(int transferModelId) {
		this.transferModelId = transferModelId;
	}
	public int getTransferToolId() {
		return transferToolId;
	}
	public void setTransferToolId(int transferToolId) {
		this.transferToolId = transferToolId;
	}
	public int getRequestNum() {
		return requestNum;
	}
	public void setRequestNum(int requestNum) {
		this.requestNum = requestNum;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
