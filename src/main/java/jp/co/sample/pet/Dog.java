package jp.co.sample.pet;

public class Dog extends Animal {

	public String walkLocation;

	public Dog() {
	}

	public Dog(String string, int i, int j, int k, String string2, String string3) {
		super.name = string;
		super.age = i;
		super.height = j;
		super.weight = k;
		super.breed = string2;
		this.walkLocation = string3;

	}

	public boolean isFat() {
		return weight > 15;
	}

	public String getWalkingPlace() {

		return walkLocation;
	}

	public void setWalkingPlace() {

	}

	@Override
	public boolean ifFat() {

		return false;
	}

}
