package jp.co.sample.pet;

public class Dog extends Animal {

	public Dog() {
	}

	public Dog(String string, int i, int j, int k, String string2, String string3) {
		super.name = name;
		super.age = age;
		super.height = height;
		super.weight = weight;
		super.breed = breed;
		super.walkLocation = walkLocation;

	}

	public boolean isFat() {
		if (weight > 15) {

			return true;
		} else {
			return false;
		}
	}

	public String getWalkingPlace() {

		return "代々木公園";
	}

	public void setWalkingPlace() {

	}

	@Override
	public boolean ifFat() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
