package jp.co.sample.pet;

public class Cat extends Animal {
	public String name;
	public int age;
	public int height;
	public int weight;
	public String breed;
	public String walkLocation;
	public String favoriteitem;

	public Cat() {

	}

	public Cat(String string, int i, int j, int k, String string2, String string3) {
		this.name = name;
		super.age = age;
		super.height = height;
		super.weight = weight;
		super.breed = breed;
		super.favoriteitem = favoriteitem;
	}

	public boolean isFat() {
		if (weight > 5) {
			return true;
		}
		return false;
	}

	public String getFavoriteItem() {
		favoriteitem = "猫じゃらし";
		return favoriteitem;
	}

	public void setFavoriteItem(String item) {

	}

	@Override
	public boolean ifFat() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
