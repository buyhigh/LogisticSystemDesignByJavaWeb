package wuliu.entity;

public class SendCar {
	private int sendCarId;
	private int driverId;
	private String driverName;
	private String transferName;
	private int sendTraTaskId;
	private int state;
	
	public SendCar(int sendCarId, int driverId, String driverName,
			String transferName, int sendTraTaskId,int state) {
		this.sendCarId = sendCarId;
		this.driverId = driverId;
		this.driverName = driverName;
		this.transferName = transferName;
		this.sendTraTaskId = sendTraTaskId;
		this.state = state;
	}
	public SendCar() {
	}
	public int getSendCarId() {
		return sendCarId;
	}
	public void setSendCarId(int sendCarId) {
		this.sendCarId = sendCarId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getTransferName() {
		return transferName;
	}
	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}
	public int getSendTraTaskId() {
		return sendTraTaskId;
	}
	public void setSendTraTaskId(int sendTraTaskId) {
		this.sendTraTaskId = sendTraTaskId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
