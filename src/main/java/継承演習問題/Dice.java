package 継承演習問題;

public class Dice {

	int number = 1;
	int kaisu;

	public int cast() {

		return number = ((int) (Math.random() * 6 + 1));

	}

	public int see() {

		return number;

	}
}