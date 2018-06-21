package wuliu.dto;

import wuliu.entity.SendCar;

public class SendCarDto extends SendCar {
	private String stateStr;

	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	
}
