package jp.co.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jp.co.sample.pet.Cat;

class CatTest {
	private Cat cat;

	@BeforeEach
	public void setUp() {

		cat = new Cat("タマ", 3, 40, 4, "アメリカンショートヘア", "猫じゃらし");
	}

	@Test
	public void isFat() {

		assertFalse(cat.isFat());
	}

	@Test
	public void getFavoriteItem() {
		assertEquals("猫じゃらし", cat.getFavoriteItem() );
	}

}