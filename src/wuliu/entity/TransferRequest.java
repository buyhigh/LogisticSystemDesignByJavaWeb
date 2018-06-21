package wuliu.entity;

public class TransferRequest {
	private int transferRequestId;
	private int dispatchId;
	private int transferToolId;
	private int requestNum;
	private int state;
	
	public TransferRequest() {}

	public TransferRequest(int transferRequestId, int dispatchId,
			int transferToolId, int state) {
		this.transferRequestId = transferRequestId;
		this.dispatchId = dispatchId;
		this.transferToolId = transferToolId;
		this.state = state;
	}

	public int getTransferRequestId() {
		return transferRequestId;
	}

	public void setTransferRequestId(int transferRequestId) {
		this.transferRequestId = transferRequestId;
	}

	public int getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}

	public int getTransferToolId() {
		return transferToolId;
	}

	public void setTransferToolId(int transferToolId) {
		this.transferToolId = transferToolId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(int requestNum) {
		this.requestNum = requestNum;
	}
	
	
}
