package 抽象クラスとインターフェース演習;

public class Test {

	public static void main(String[] args) {

		Greet greet;
		Polygon answer;

		greet = new GoodMorning();
		greet.hello();

		greet = new GoodEvening();
		greet.hello();

		answer = new Square();
		answer.dispArea();

		answer = new Triangle();
		answer.dispArea();
	}
}
