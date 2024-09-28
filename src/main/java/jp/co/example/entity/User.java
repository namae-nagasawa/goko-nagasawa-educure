package jp.co.example.entity;

public class User {

	private Integer id;
	private String name;
	private Integer price;

	//entityはカラム名から引っ張ってきた値なので同じにしないといけない
	public User() {

	}

	public User(String userName, Integer userPrice) {
		this.name = userName;
		this.price = userPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
