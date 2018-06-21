package wuliu.entity;

public class Goods {
	private int goodId;
	private String goodName;
	private String goodWeight;
	private String goodBulk;//商品体积
	private String goodUnit;
	private String goodPrice;
	private String inDate;
	
	public Goods(){}
	
	

	public Goods(int goodId, String goodName, String goodWeight,
			String goodBulk, String goodUnit, String goodPrice) {
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodWeight = goodWeight;
		this.goodBulk = goodBulk;
		this.goodUnit = goodUnit;
		this.goodPrice = goodPrice;
	}



	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodWeight() {
		return goodWeight;
	}

	public void setGoodWeight(String goodWeight) {
		this.goodWeight = goodWeight;
	}

	public String getGoodBulk() {
		return goodBulk;
	}

	public void setGoodBulk(String goodBulk) {
		this.goodBulk = goodBulk;
	}

	public String getGoodUnit() {
		return goodUnit;
	}

	public void setGoodUnit(String goodUnit) {
		this.goodUnit = goodUnit;
	}

	public String getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(String goodPrice) {
		this.goodPrice = goodPrice;
	}



	public String getInDate() {
		return inDate;
	}



	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	
	
	
}
