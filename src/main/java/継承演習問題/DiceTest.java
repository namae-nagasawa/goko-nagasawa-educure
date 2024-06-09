package 継承演習問題;

public class DiceTest {

	public static void main(String[] args) {
		int i = 0;

		Dice num1 = new Dice();

		System.out.println(num1.see());

		for (i = 0; i <= 30; i++) {
			System.out.println(num1.cast());

		}

	}
}
