package model;

public class pay {
	private String payId;
	private String payMethods;
	
	public pay() {
		super();
	}
	public pay(String payId, String payMethods) {
		super();
		this.payId = payId;
		this.payMethods = payMethods;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getPayMethods() {
		return payMethods;
	}
	public void setPayMethods(String payMethods) {
		this.payMethods = payMethods;
	}
	@Override
	public String toString() {
		return "pay [payId=" + payId + ", payMethods=" + payMethods + "]";
	}
	
	
	
}
