package wuliu.dto;

import wuliu.entity.SendTraTask;

public class SendTraTaskDto extends SendTraTask {
	private String transferPlaceStr;//���������
	private String transferModelStr;//����������������
	private String transferToolStr;//������������
	private String stateStr;//״̬����
	public String getTransferPlaceStr() {
		return transferPlaceStr;
	}
	public void setTransferPlaceStr(String transferPlaceStr) {
		this.transferPlaceStr = transferPlaceStr;
	}
	public String getTransferModelStr() {
		return transferModelStr;
	}
	public void setTransferModelStr(String transferModelStr) {
		this.transferModelStr = transferModelStr;
	}
	public String getTransferToolStr() {
		return transferToolStr;
	}
	public void setTransferToolStr(String transferToolStr) {
		this.transferToolStr = transferToolStr;
	}
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	
}
