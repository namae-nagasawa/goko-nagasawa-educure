package jp.co.sample.pet;

public class Cat extends Animal {

	public String favoriteitem;

	public Cat() {

	}

	public Cat(String string, int i, int j, int k, String string2, String string3) {
		super.name = string;
		super.age = i;
		super.height = j;
		super.weight = k;
		super.breed = string2;
		this.favoriteitem = string3;
	}

	public boolean isFat() {
		return weight > 5;
	}

	public String getFavoriteItem() {
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
