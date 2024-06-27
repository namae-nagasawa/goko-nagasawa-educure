package jp.co.sample.pet;

public abstract class Animal implements Pet {

	public String name;
	public int age;
	public int height;
	public int weight;
	public String breed;
	public String walkLocation;
	public String favoriteitem;
	
	public abstract boolean ifFat() ;

	public String getType() {
		return breed;

	}

	public void setType(String string) {

	}

	@Override
	public String getName() {
		return name;

	}

	@Override
	public void setName(String name) {
	}

	@Override
	public int getAge() {
		return 0;
	}

	@Override
	public void setAge(int age) {
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void setHeight(int height) {
	}

	@Override
	public int getWeight() {
		return 0;
	}

	@Override
	public void setWeight(int weight) {
	}

	
}
