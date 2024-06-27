package jp.co.sample.pet;

public class Dog extends Animal {

	public Dog() {
	}

	public Dog(String string, int i, int j, int k, String string2, String string3) {
		super.name = string;
		super.age = i;
		super.height = j;
		super.weight = k;
		super.breed = string2;
		super.walkLocation = string3;
		

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
	public Dog(String string) {
		name="ポチ";
	}
}
