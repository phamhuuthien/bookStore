package model;

import java.sql.Date;
import java.util.Objects;

public class Users {
	private String userId;
	private String fullName ;
	private String userName;
	private String password;
	private String sex;
	private String address;
	private String deliveryAddress;
	private Date dateOfBirth;
	private String email;
	private Boolean receiveEmail;
	private int role;
	public Users() {
		super();
	}
	public Users(String userId, String fullName, String userName, String password, String sex, String address,
			String deliveryAddress, Date dateOfBirth, String email, Boolean receiveEmail, int role) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.receiveEmail = receiveEmail;
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(Boolean receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", password="
				+ password + ", sex=" + sex + ", address=" + address + ", deliveryAddress=" + deliveryAddress
				+ ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", receiveEmail=" + receiveEmail + ", role="
				+ role + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(userId, other.userId);
	}
	
}
