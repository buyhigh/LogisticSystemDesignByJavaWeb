package wuliu.entity;

public class Profile {
	private int profileId;
	private String userName;
	private String address;
	private String realName;
	private String telphone;
	
	public void Proflie(){}
	
	public void Proflie(int profileId, String userName, String address, String realName,String telphone) {
		this.profileId = profileId;
		this.userName = userName;
		this.address = address;
		this.realName = realName;
		this.telphone = telphone;
	}


	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
}
