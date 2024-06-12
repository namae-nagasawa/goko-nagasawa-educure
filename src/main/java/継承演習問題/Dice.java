package 継承演習問題;

public class Dice {

	int number;
	int num;

	public int cast() {
		num = ((int) (Math.random() * 6 + 1));
		return num;
	}

	public int see() {
		if (number == 0) {
			number++;
			return number;

		} else {
			return cast();
		}
	}
}
