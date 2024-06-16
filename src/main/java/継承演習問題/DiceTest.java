package 継承演習問題;

public class DiceTest extends Dice {

	public static void main(String[] args) {

		Dice num1 = new Dice();
		CheatDice num2 = new CheatDice();

		System.out.println(num1.see());

		for (int i = 1; i <= 30; i++) {
			
			System.out.println(i + "回目");
			System.out.println(num2.cast());

		}
	}
}
