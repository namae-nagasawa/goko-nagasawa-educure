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

	public int getId() {
		return userId;
	}

	public void setId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

	public Integer getPrice() {
		return userPrice;
	}

	public void setPrice(Integer userPrice) {
		this.userPrice = userPrice;
	}

}
