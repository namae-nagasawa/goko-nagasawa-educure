package 継承演習問題;

public class Dice {

	int number = 1;

	public int cast() {
		number = ((int) (Math.random() * 6 + 1));
		return number;
	}

	public int see() {
		int number =6;
		return number;
	}

}
