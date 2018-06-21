package wuliu.dto;

import wuliu.entity.TransferTool;

public class TransferToolDto extends TransferTool {
	private String stateStr;
	private String modelStr;
	private String placeStr;
	
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	public String getModelStr() {
		return modelStr;
	}
	public void setModelStr(String modelStr) {
		this.modelStr = modelStr;
	}
	public String getPlaceStr() {
		return placeStr;
	}
	public void setPlaceStr(String placeStr) {
		this.placeStr = placeStr;
	}
	
	
	
	
}
