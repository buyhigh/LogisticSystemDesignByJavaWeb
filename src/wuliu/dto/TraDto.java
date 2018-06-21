package wuliu.dto;

import wuliu.entity.Tra;

public class TraDto extends Tra {
	private String dispUserName;
	private int dispNum;
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
