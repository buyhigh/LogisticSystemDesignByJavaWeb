package wuliu.entity;

public class DispUser {
	private int dispUserId;
	private String dispUserName;
	private int dispNum;
	
	
	public DispUser() {
	}
	public DispUser(int dispUserId, String dispUserName, int dispNum) {
		this.dispUserId = dispUserId;
		this.dispUserName = dispUserName;
		this.dispNum = dispNum;
	}
	public int getDispUserId() {
		return dispUserId;
	}
	public void setDispUserId(int dispUserId) {
		this.dispUserId = dispUserId;
	}
	public String getDispUserName() {
		return dispUserName;
	}
	public void setDispUserName(String dispUserName) {
		this.dispUserName = dispUserName;
	}
	public int getDispNum() {
		return dispNum;
	}
	public void setDispNum(int dispNum) {
		this.dispNum = dispNum;
	}
	
}
