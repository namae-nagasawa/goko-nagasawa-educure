package 継承演習問題;

public class DiceTest extends Dice {

	public static void main(String[] args) {

		CheatDice  num1 = new CheatDice();

		for (int num = 0; num <= 30; num++) {
			System.out.println(num1.see());

		}

	}
}