package model;

public class Cart{
	private String cartId ;
	private Users user;
	
	public Cart() {
		super();
	}

	public Cart(String cartId, Users user) {
		super();
		this.cartId = cartId;
		this.user = user;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + "]";
	}
	
}
