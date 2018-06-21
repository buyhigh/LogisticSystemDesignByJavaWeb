package wuliu.dto;

import wuliu.entity.Dispatch;

public class DispatchDto extends Dispatch {
	private String stateName;
	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
}
