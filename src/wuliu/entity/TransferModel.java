package wuliu.entity;

public class TransferModel {
	private int trmoId;
	private String trmoName;
	private String trmoWeight;
	private String trmoMulk;
	public TransferModel() {}
	public TransferModel(int trmoId, String trmoName, String trmoWeight,
			String trmoMulk) {
		this.trmoId = trmoId;
		this.trmoName = trmoName;
		this.trmoWeight = trmoWeight;
		this.trmoMulk = trmoMulk;
	}
	public int getTrmoId() {
		return trmoId;
	}
	public void setTrmoId(int trmoId) {
		this.trmoId = trmoId;
	}
	public String getTrmoName() {
		return trmoName;
	}
	public void setTrmoName(String trmoName) {
		this.trmoName = trmoName;
	}
	public String getTrmoWeight() {
		return trmoWeight;
	}
	public void setTrmoWeight(String trmoWeight) {
		this.trmoWeight = trmoWeight;
	}
	public String getTrmoMulk() {
		return trmoMulk;
	}
	public void setTrmoMulk(String trmoMulk) {
		this.trmoMulk = trmoMulk;
	}
	
	
	
	
}
