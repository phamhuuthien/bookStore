package model;

public class Cart_detail {
	private String cartDetailId;
	private Books books ;
	private Cart cart;
	private int quantity;
	private double total;
	
	public Cart_detail() {
		super();
	}

	public Cart_detail(String cartDetailId, Books books, Cart cart, int quantity) {
		super();
		this.cartDetailId = cartDetailId;
		this.books = books;
		this.cart = cart;
		this.quantity = quantity;
	}

	public String getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(String cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return books.getPrice()*this.getQuantity();
	}

	@Override
	public String toString() {
		return "Cart_detail [cartDetailId=" + cartDetailId + ", books=" + books + ", cart=" + cart + ", quantity="
				+ quantity + ", total=" + total + "]";
	}
	
//	public static void main(String[] args) {
//		Author author = new Author();
//		author.setAuthorId("1");
//		Category ct = new Category();
//		ct.setCode("RT6");
//		Cart_detail test = new Cart_detail("212",new Books("00126d95-4a73-4072-bd18-11edee021428","sdsd",author,"2313",2.0,2,"dsad",ct,"dsd",2.0),new Cart(null,null),1);
//		System.out.println(test.getTotal());
//	}
}
