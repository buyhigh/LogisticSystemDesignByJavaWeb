package wuliu.entity;

public class OutStoreRequest {
	private int outStoreRequestId;
	private int dispatchId;
	private int storeId;
	private int state;
	public OutStoreRequest() {}

	public OutStoreRequest(int outStoreRequestId, int dispatchId, int storeId,
			int state) {
		this.outStoreRequestId = outStoreRequestId;
		this.dispatchId = dispatchId;
		this.storeId = storeId;
		this.state = state;
	}

	public int getOutStoreRequestId() {
		return outStoreRequestId;
	}

	public void setOutStoreRequestId(int outStoreRequestId) {
		this.outStoreRequestId = outStoreRequestId;
	}

	public int getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
}
