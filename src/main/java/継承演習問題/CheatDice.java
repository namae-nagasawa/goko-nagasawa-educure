package 継承演習問題;

public class CheatDice extends Dice {

	int kaisu;
	//int number;

	@Override
	public int cast() {
		kaisu++;
		if (kaisu % 6 == 0) {

			number = 6;
			return number;
		} else {
			number = ((int) (Math.random() * 6 + 1));
			return number;
		}

	}

}
