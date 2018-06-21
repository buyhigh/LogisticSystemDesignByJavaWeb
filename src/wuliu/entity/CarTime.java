package wuliu.entity;

public class CarTime {
	private int driverId;
	private int transferToolId;
	public CarTime() {
	}
	public CarTime(int driverId, int transferToolId) {
		this.driverId = driverId;
		this.transferToolId = transferToolId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getTransferToolId() {
		return transferToolId;
	}
	public void setTransferToolId(int transferToolId) {
		this.transferToolId = transferToolId;
	}
	
	
}
