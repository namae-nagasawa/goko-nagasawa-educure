import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitUtilTest {

	@Test
	void testIsNumber1() {
		boolean result = JunitUtil.isNumber("-2147483649");
		assertEquals(false, result);

	}

	@Test
	void testIsNumber2() {
		boolean result = JunitUtil.isNumber("-2147483648");
		assertEquals(true, result);

	}

	@Test
	void testIsNumber3() {
		boolean result = JunitUtil.isNumber("0");
		assertEquals(true, result);
	}

	@Test
	void testIsNumber4() {
		boolean result = JunitUtil.isNumber("2147483647");
		assertEquals(true, result);

	}

	@Test
	void testIsNumber5() {
		boolean result = JunitUtil.isNumber("2147483648");
		assertEquals(false, result);
	}

	@Test
	void testIsNumber6() {
		boolean result = JunitUtil.isNumber(null);
		assertEquals(false, result);
	}

	@Test
	void testIsNumber7() {
		boolean result = JunitUtil.isNumber("");
		assertEquals(false, result);

	}

	@Test
	void testIsNumber8() {
		boolean result = JunitUtil.isNumber("a");
		assertEquals(false, result);

	}

	@Test
	void testIsNumber9() {
		boolean result = JunitUtil.isNumber("1");
		assertEquals(true, result);

	}

	@Test
	void testIsNumber10() {
		boolean result = JunitUtil.isNumber("あ");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode1() {
		boolean result = JunitUtil.isPostalCode("017-2298");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode2() {
		boolean result = JunitUtil.isPostalCode("381-6065");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode3() {
		boolean result = JunitUtil.isPostalCode("0862477");
		assertEquals(true, result);
	}

	@Test
	void testIsPostalCode4() {
		boolean result = JunitUtil.isPostalCode("8483001");
		assertEquals(true, result);
	}

	@Test
	void testIsPostalCode5() {
		boolean result = JunitUtil.isPostalCode("9496-058");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode6() {
		boolean result = JunitUtil.isPostalCode("993-367");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode7() {
		boolean result = JunitUtil.isPostalCode(null);
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode8() {
		boolean result = JunitUtil.isPostalCode("");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode9() {
		boolean result = JunitUtil.isPostalCode("a");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode10() {
		boolean result = JunitUtil.isPostalCode("1");
		assertEquals(false, result);
	}

	@Test
	void testIsPostalCode11() {
		boolean result = JunitUtil.isPostalCode("あ");
		assertEquals(false, result);
	}

	@Test
	void testIsSmallAlphabet1() {
		boolean result = JunitUtil.isSmallAlphabet("a");
		assertEquals(true, result);

	}

	@Test
	void testIsSmallAlphabet2() {
		boolean result = JunitUtil.isSmallAlphabet("b");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet3() {
		boolean result = JunitUtil.isSmallAlphabet("c");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet4() {
		boolean result = JunitUtil.isSmallAlphabet("d");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet5() {
		boolean result = JunitUtil.isSmallAlphabet("e");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet6() {
		boolean result = JunitUtil.isSmallAlphabet("f");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet7() {
		boolean result = JunitUtil.isSmallAlphabet("g");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet8() {
		boolean result = JunitUtil.isSmallAlphabet("h");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet9() {
		boolean result = JunitUtil.isSmallAlphabet("i");
		assertEquals(false, result);//バグ修正
	}

	@Test
	void testIsSmallAlphabet10() {
		boolean result = JunitUtil.isSmallAlphabet("j");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet11() {
		boolean result = JunitUtil.isSmallAlphabet("k");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet12() {
		boolean result = JunitUtil.isSmallAlphabet("l");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet13() {
		boolean result = JunitUtil.isSmallAlphabet("m");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet14() {
		boolean result = JunitUtil.isSmallAlphabet("n");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet15() {
		boolean result = JunitUtil.isSmallAlphabet("o");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet16() {
		boolean result = JunitUtil.isSmallAlphabet("p");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet17() {
		boolean result = JunitUtil.isSmallAlphabet("q");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet18() {
		boolean result = JunitUtil.isSmallAlphabet("r");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet19() {
		boolean result = JunitUtil.isSmallAlphabet("s");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet20() {
		boolean result = JunitUtil.isSmallAlphabet("t");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet21() {
		boolean result = JunitUtil.isSmallAlphabet("u");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet22() {
		boolean result = JunitUtil.isSmallAlphabet("v");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet23() {
		boolean result = JunitUtil.isSmallAlphabet("w");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet24() {
		boolean result = JunitUtil.isSmallAlphabet("x");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet25() {
		boolean result = JunitUtil.isSmallAlphabet("y");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet26() {
		boolean result = JunitUtil.isSmallAlphabet("z");
		assertEquals(true, result);
	}

	@Test
	void testIsSmallAlphabet27() {
		boolean result = JunitUtil.isSmallAlphabet(null);
		assertEquals(false, result);
	}

	@Test
	void testIsSmallAlphabet28() {
		boolean result = JunitUtil.isSmallAlphabet("");
		assertEquals(false, result);
	}

	@Test
	void testIsSmallAlphabet29() {
		boolean result = JunitUtil.isSmallAlphabet("1");
		assertEquals(false, result);
	}

	@Test
	void testIsSmallAlphabet30() {
		boolean result = JunitUtil.isSmallAlphabet("!");
		assertEquals(false, result);
	}

	@Test
	void testIsSmallAlphabet31() {
		boolean result = JunitUtil.isSmallAlphabet("あ");
		assertEquals(false, result);
	}

	@Test
	void testIsSmallAlphabet32() {
		boolean result = JunitUtil.isSmallAlphabet("A");
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle1() {
		boolean result = JunitUtil.isTriangle(0, 0, 0);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle2() {
		boolean result = JunitUtil.isTriangle(0, 0, 1);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle3() {
		boolean result = JunitUtil.isTriangle(0, 1, 0);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle4() {
		boolean result = JunitUtil.isTriangle(1, 0, 0);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle5() {
		boolean result = JunitUtil.isTriangle(0, 1, 1);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle6() {
		boolean result = JunitUtil.isTriangle(1, 0, 1);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle7() {
		boolean result = JunitUtil.isTriangle(1, 1, 0);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle8() {
		boolean result = JunitUtil.isTriangle(1, 1, 1);
		assertEquals(true, result);
	}

	@Test
	void testIsTriangle9() {
		boolean result = JunitUtil.isTriangle(1, 1, 2147483647);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle10() {
		boolean result = JunitUtil.isTriangle(1, 2147483647, 1);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle11() {
		boolean result = JunitUtil.isTriangle(2147483647, 1, 1);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle12() {
		boolean result = JunitUtil.isTriangle(1, 2147483647, 2147483647);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle13() {
		boolean result = JunitUtil.isTriangle(2147483647, 1, 2147483647);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle14() {
		boolean result = JunitUtil.isTriangle(2147483647, 2147483647, 1);
		assertEquals(false, result);
	}

	@Test
	void testIsTriangle15() {
		boolean result = JunitUtil.isTriangle(2147483647, 2147483647, 2147483647);
		assertEquals(false, result);
	}

	@Test
	void testIsSquareNumber1() {
		int result = JunitUtil.isSquareNumber(-1);
		assertEquals(-1, result);
	}

	@Test
	void testIsSquareNumber2() {
		int result = JunitUtil.isSquareNumber(0);
		assertEquals(0, result);
	}

	@Test
	void testIsSquareNumber3() {
		int result = JunitUtil.isSquareNumber(1);
		assertEquals(1, result);
	}

	@Test
	void testIsSquareNumber4() {
		int result = JunitUtil.isSquareNumber(2);
		assertEquals(-1, result);
	}

	@Test
	void testIsSquareNumber5() {
		int result = JunitUtil.isSquareNumber(3);
		assertEquals(-1, result);
	}

	@Test
	void testIsSquareNumber6() {
		int result = JunitUtil.isSquareNumber(4);
		assertEquals(2, result);
	}

	@Test
	void testIsSquareNumber7() {
		int result = JunitUtil.isSquareNumber(100000);
		assertEquals(-1, result);
	}

	@Test
	void testIsSquareNumber8() {
		int result = JunitUtil.isSquareNumber(100001);
		assertEquals(-1, result);
	}

}