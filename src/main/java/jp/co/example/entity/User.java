package jp.co.example.entity;

public class User {

	private String userName;
	private Integer userPrice;
	private Integer userId;

	public User() {

	}

	public User(String name, Integer price) {
		this.userName = name;
		this.userPrice = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserPrice() {
		return userPrice;
	}

	public void setUserPrice(Integer userPrice) {
		this.userPrice = userPrice;
	}

}
