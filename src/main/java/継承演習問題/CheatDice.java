package 継承演習問題;

public class CheatDice extends Dice {

	//int number;
	//int num;
	int six = 6;

	//public int cast() {
	//	num = ((int) (Math.random() * 6 + 1));
	//return num;
	//}

	public int see() {
		if (number == 0) {
			number=1;;
			return number;
		} else if (number % 6 == 0) {
			number++;
			return six;
		} else {
			number++;
			return cast();
		}
	}

}
