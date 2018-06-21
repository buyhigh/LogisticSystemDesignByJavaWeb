package wuliu.entity;

public class Driver {
	private int driverId;
	private String driverName;
	private int driverAge;
	private int driverSex;
	private String driverPhoto;
	private int driverState;
	public Driver() {
	}
	public Driver(int driverId, String driverName, int driverAge,
			int driverSex, String driverPhoto, int driverState) {
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverAge = driverAge;
		this.driverSex = driverSex;
		this.driverPhoto = driverPhoto;
		this.driverState = driverState;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public int getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(int driverAge) {
		this.driverAge = driverAge;
	}
	public int getDriverSex() {
		return driverSex;
	}
	public void setDriverSex(int driverSex) {
		this.driverSex = driverSex;
	}
	public String getDriverPhoto() {
		return driverPhoto;
	}
	public void setDriverPhoto(String driverPhoto) {
		this.driverPhoto = driverPhoto;
	}
	public int getDriverState() {
		return driverState;
	}
	public void setDriverState(int driverState) {
		this.driverState = driverState;
	}
	
	
}
