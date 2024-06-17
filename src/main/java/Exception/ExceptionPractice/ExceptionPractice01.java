package Exception.ExceptionPractice;

public class ExceptionPractice01 {
	public static void main(String[] args) {
		try {

			Integer.parseInt("abc");

		} catch (NumberFormatException a) {

			System.out.println("NumberFormatException Integer.parseInt abc" + a);

		}
		try {
			Integer.parseInt("def");
		} catch (NumberFormatException d) {

			System.out.println("NumberFormatException Integer.parseInt def" + d);

		}
	}
}