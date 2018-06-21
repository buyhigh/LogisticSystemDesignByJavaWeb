package wuliu.entity;

public class State {
	private int stateId;
	private String stateName;
	private String stateDesc;
	
	public State() {}
	public State(int stateId, String stateName, String stateDesc) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.stateDesc = stateDesc;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateDesc() {
		return stateDesc;
	}
	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
	
	
	
}
