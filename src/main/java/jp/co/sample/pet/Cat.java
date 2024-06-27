package jp.co.sample.pet;

public class Cat extends Animal {
	

	public Cat() {

	}

	public Cat(String string, int i, int j, int k, String string2, String string3) {
		super.name = string;
		super.age = i;
		super.height = j;
		super.weight = k;
		super.breed = string2;
		super.favoriteitem = string3;
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
