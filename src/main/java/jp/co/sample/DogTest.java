package jp.co.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.sample.pet.Dog;

class DogTest {

	@Test
	public void isFat() {
		boolean result =Dog.isFat();
		boolean expected=true;
		
		assertEquals(expected,result);
	}

}
