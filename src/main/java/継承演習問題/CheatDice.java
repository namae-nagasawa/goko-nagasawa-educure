package 継承演習問題;

public class CheatDice extends Dice {
	public static void main(String[] args) {

		int i = 1;

		Dice num1 = new Dice();

		for (i = 1; i <= 36; i++) {
			if (i % 6 == 0) {
				System.out.println(num1.see());
			} else {
				System.out.println(num1.cast());
			}
		}

	}
}