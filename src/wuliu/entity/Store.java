package wuliu.entity;

public class Store {
	private int storeId;
	private String storeName;
	private String address;
	
	public Store(){}
	
	public Store(int storeId, String storeName, String address) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
