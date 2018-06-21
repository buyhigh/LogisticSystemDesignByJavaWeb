package wuliu.entity;

public class TransferTool {
	private int transferId;
	private String transferNum;
	private String transferName;
	private int transferState;
	private int transferModel;
	private int transferPlace;
	private int quantity;
	
	public TransferTool() {}

	public TransferTool(int transferId, String transferNum,
			String transferName, int transferState, int transferModel,
			int transferPlace) {
		this.transferId = transferId;
		this.transferNum = transferNum;
		this.transferName = transferName;
		this.transferState = transferState;
		this.transferModel = transferModel;
		this.transferPlace = transferPlace;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getTransferNum() {
		return transferNum;
	}

	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}

	public String getTransferName() {
		return transferName;
	}

	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}

	public int getTransferState() {
		return transferState;
	}

	public void setTransferState(int transferState) {
		this.transferState = transferState;
	}

	public int getTransferModel() {
		return transferModel;
	}

	public void setTransferModel(int transferModel) {
		this.transferModel = transferModel;
	}

	public int getTransferPlace() {
		return transferPlace;
	}

	public void setTransferPlace(int transferPlace) {
		this.transferPlace = transferPlace;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
