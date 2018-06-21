package wuliu.entity;

public class Tra {
	private int traId;
	private String goodName;
	private int goodQuantity;
	private String receName;
	private String receTel;
	private String receProvince;
	private String receCity;
	private String receStreet;
	private int transferTaskId;
	private int dispUserId;
	
	public Tra() {
	}

	public Tra(int traId, String goodName, int goodQuantity, String receName,
			String receTel, String receProvince, String receCity,
			String receStreet, int transferTaskId, int dispUserId) {
		this.traId = traId;
		this.goodName = goodName;
		this.goodQuantity = goodQuantity;
		this.receName = receName;
		this.receTel = receTel;
		this.receProvince = receProvince;
		this.receCity = receCity;
		this.receStreet = receStreet;
		this.transferTaskId = transferTaskId;
		this.dispUserId = dispUserId;
	}

	public int getTraId() {
		return traId;
	}

	public void setTraId(int traId) {
		this.traId = traId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public int getGoodQuantity() {
		return goodQuantity;
	}

	public void setGoodQuantity(int goodQuantity) {
		this.goodQuantity = goodQuantity;
	}

	public String getReceName() {
		return receName;
	}

	public void setReceName(String receName) {
		this.receName = receName;
	}

	public String getReceTel() {
		return receTel;
	}

	public void setReceTel(String receTel) {
		this.receTel = receTel;
	}

	public String getReceProvince() {
		return receProvince;
	}

	public void setReceProvince(String receProvince) {
		this.receProvince = receProvince;
	}

	public String getReceCity() {
		return receCity;
	}

	public void setReceCity(String receCity) {
		this.receCity = receCity;
	}

	public String getReceStreet() {
		return receStreet;
	}

	public void setReceStreet(String receStreet) {
		this.receStreet = receStreet;
	}

	public int getTransferTaskId() {
		return transferTaskId;
	}

	public void setTransferTaskId(int transferTaskId) {
		this.transferTaskId = transferTaskId;
	}

	public int getDispUserId() {
		return dispUserId;
	}

	public void setDispUserId(int dispUserId) {
		this.dispUserId = dispUserId;
	}
	
	
	
}
