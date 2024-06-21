
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Combination_Calc_Test {
	@Test
	void testIsnCr1() {
		int result = Combination_Calc.nCr(5, 2);
		assertEquals(10, result);
	}

	@Test
	void testIsnCr2() {
		int result = Combination_Calc.nCr(2, 5);
		assertEquals(0, result);
	}

	@Test
	void testIsnCr3() {
		int result = Combination_Calc.nCr(2, 0);
		assertEquals(1, result);
	}

}
