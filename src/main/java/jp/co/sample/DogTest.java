package jp.co.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.co.sample.pet.Dog;

class DogTest {
	private Dog dog;

	@BeforeEach
	public void setUp() {

		dog = new Dog("ポチ", 5, 55, 20, "柴犬", "代々木公園");
	}

	@Test
	public void isFat() {

		assertTrue(dog.isFat());
	}

	@Test
	public void getWalkingPlace() {
		assertEquals("代々木公園", dog.getWalkingPlace());
	}

}
