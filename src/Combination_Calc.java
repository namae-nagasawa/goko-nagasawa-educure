
public class Combination_Calc {

	public int n;
	public int r;

	public static int nCr(int n, int r) {
		if (r > n) {
			return 0;
		} else if (r == 0 || r == n) {
			return 1;
		}
		int result = 1;
		for (int i = 1; i <= r; i++) {
			result = result * (n - i + 1) / i;

		}
		return result;
	}
}