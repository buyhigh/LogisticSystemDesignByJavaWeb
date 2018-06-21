package wuliu.entity;

public class User {
	private int userId;
	private String userName;
	private String userPass;
	private int userType;
	
	public User(){}
	
	public User(int userId, String userName, String userPass, int userType) {
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userType = userType;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
}
