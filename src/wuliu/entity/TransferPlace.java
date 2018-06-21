package wuliu.entity;

public class TransferPlace {
	private int transferPlaceId;
	private String transferPlaceName;
	
	public TransferPlace() {}

	public TransferPlace(int transferPlaceId, String transferPlaceName) {
		this.transferPlaceId = transferPlaceId;
		this.transferPlaceName = transferPlaceName;
	}

	public int getTransferPlaceId() {
		return transferPlaceId;
	}

	public void setTransferPlaceId(int transferPlaceId) {
		this.transferPlaceId = transferPlaceId;
	}

	public String getTransferPlaceName() {
		return transferPlaceName;
	}

	public void setTransferPlaceName(String transferPlaceName) {
		this.transferPlaceName = transferPlaceName;
	}
	
	
	
}
