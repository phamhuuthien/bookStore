package model;

import java.sql.Date;

public class Order_detail {
	private String order_detailId;
	private Books book;
	private Order order;
	private int quality;
	private Double price;
	private Double discount;
	private Double totalPrice;
	public Order_detail() {
		super();
	}
	public Order_detail(String order_detailId, Books book, Order order, int quality, Double price, Double discount,
			 Double totalPrice) {
		super();
		this.order_detailId = order_detailId;
		this.book = book;
		this.order = order;
		this.quality = quality;
		this.price = price;
		this.discount = discount;
		this.totalPrice = totalPrice;
	}
	public String getOrder_detailId() {
		return order_detailId;
	}
	public void setOrder_detailId(String order_detailId) {
		this.order_detailId = order_detailId;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order_deTail [order_detailId=" + order_detailId + ", book=" + book + ", order=" + order + ", quality="
				+ quality + ", price=" + price + ", discount=" + discount + ", totalPrice="
				+ totalPrice + "]";
	}
	
}
