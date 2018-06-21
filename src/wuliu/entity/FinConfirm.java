package wuliu.entity;

public class FinConfirm {
	private int finConfirmId;
	private int dispatchId;
	private int traTaskId;
	private int traState;
	private String consumer;
	private String staff;
	
	public FinConfirm(){}
	
	public FinConfirm(int finConfirmId, int dispatchId, int traTaskId, int traState,String consumer,String staff) {
		this.finConfirmId = finConfirmId;
		this.dispatchId = dispatchId;
		this.traTaskId = traTaskId;
		this.traState = traState;
		this.consumer = consumer;
		this.staff = staff;
	}


	public int getFinConfirmId() {
		return finConfirmId;
	}
	public void setFinConfirmId(int finConfirmId) {
		this.finConfirmId = finConfirmId;
	}
	public int getDispatchId() {
		return dispatchId;
	}
	public void setDispatchId(int dispatchId) {
		this.dispatchId = dispatchId;
	}
	public int getTraTaskId() {
		return traTaskId;
	}
	public void setTraTaskId(int traTaskId) {
		this.traTaskId = traTaskId;
	}
	public int getTraState() {
		return traState;
	}
	public void setTraState(int traState) {
		this.traState = traState;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	
}
