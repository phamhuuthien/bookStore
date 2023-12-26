package model;

import java.sql.Date;

public class Order {
	private String orderId ;
	private Users user ;
	private pay pay;
	private Date orderDate;
	private String orderStatus;
	private Date orderDelivery;
	private String receivingAddress;
	private double total;
	public Order() {
		super();
	}
	public Order(String orderId, Users user, pay pay, Date orderDate, String orderStatus, Date orderDelivery,
			String receivingAddress) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.pay = pay;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderDelivery = orderDelivery;
		this.receivingAddress = receivingAddress;
	}
	
	public Order(String orderId, Users user, model.pay pay, Date orderDate, String orderStatus, Date orderDelivery,
			String receivingAddress, double total) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.pay = pay;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderDelivery = orderDelivery;
		this.receivingAddress = receivingAddress;
		this.total = total;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public pay getPay() {
		return pay;
	}
	public void setPay(pay pay) {
		this.pay = pay;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDelivery() {
		return orderDelivery;
	}
	public void setOrderDelivery(Date orderDelivery) {
		this.orderDelivery = orderDelivery;
	}
	public String getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", pay=" + pay + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + ", orderDelivery=" + orderDelivery + ", receivingAddress="
				+ receivingAddress + "]";
	}
	
}
