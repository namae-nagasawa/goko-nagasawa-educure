package 継承演習問題;

public class Dice {

	public int number = 1;

	public static int Cast() {
		int randomNum1 = ((int) (Math.random() * 6) + 1);
		return randomNum1;
	}

	public int see() {
		return number;
	}
}
