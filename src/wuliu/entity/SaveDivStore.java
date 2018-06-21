package wuliu.entity;

public class SaveDivStore {
	private int id;
	private String dispatchId;
	private String goodsName;
	private int goodsQuantity;
	private String creater;
	private int state;
	private String sendTime;
	
	public void SaveDivStore(){}
	
	public void SaveDivStore(String dispatchId, String goodsName, int goodsQuantity, String creater,int state,String sendTime) {
		this.dispatchId = dispatchId;
		this.goodsName = goodsName;
		this.goodsQuantity = goodsQuantity;
		this.creater = creater;
		this.state = state;
		this.sendTime = sendTime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDispatchId() {
		return dispatchId;
	}
	public void setDispatchId(String dispatchId) {
		this.dispatchId = dispatchId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
}
