package jp.co.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.sample.pet.Cat;
import jp.co.sample.pet.Dog;
import jp.co.sample.util.PetUtil;

class PetUtilTest {

	@Test
	public void testIsNullOrEmpty() {
		assertTrue(PetUtil.isNullOrEmpty(null));
		assertTrue(PetUtil.isNullOrEmpty(""));
	}

	// isNumberメソッドのテスト
	@Test
	public void testIsNumber() {
		assertTrue(PetUtil.isNumber("123"));
		assertFalse(PetUtil.isNumber("abc"));
		assertFalse(PetUtil.isNumber(""));
	}

	// checkAndParseIntメソッドのテスト
	@Test
	public void testCheckAndParseInt() {
		assertEquals(123, PetUtil.checkAndParseInt("123"));
		assertNull(PetUtil.checkAndParseInt("abc"));
		assertNull(PetUtil.checkAndParseInt(""));
	}

	// getOptionTitleStrメソッドのテスト
	@Test
	public void testGetOptionTitleStr() {
		Dog dog = new Dog();
		assertEquals("散歩場所", PetUtil.getOptionTitleStr(dog));

		Cat cat = new Cat();
		assertEquals("お気に入り遊具", PetUtil.getOptionTitleStr(cat));

	}

	// getOptionStrメソッドのテスト
	@Test
	public void testGetOptionStr() {
		Dog dog = new Dog();
		dog.setWalkingPlace(null);
		assertEquals(null, PetUtil.getOptionStr(dog));

		Cat cat = new Cat();
		cat.setFavoriteItem(null);
		assertEquals(null, PetUtil.getOptionStr(cat));

	}

	// isDogメソッドのテスト
	@Test
	public void testIsDog() {
		Dog dog = new Dog();
		assertTrue(PetUtil.isDog(dog));

		Cat cat = new Cat();
		assertFalse(PetUtil.isDog(cat));

	}

	// isCatメソッドのテスト
	@Test
	public void testIsCat() {
		Cat cat = new Cat();
		assertTrue(PetUtil.isCat(cat));

		Dog dog = new Dog();
		assertFalse(PetUtil.isCat(dog));

	}

	// isAnimalメソッドのテスト
	@Test
	public void testIsAnimal() {
		Dog dog = new Dog();
		assertTrue(PetUtil.isAnimal(dog));

		Cat cat = new Cat();
		assertTrue(PetUtil.isAnimal(cat));

	}
}
