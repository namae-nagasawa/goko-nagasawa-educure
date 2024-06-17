package Exception.ExceptionPractice;

public class ExceptionPractice01 {
	public static void main(String[] args) {
		String[] eng = { "abc", "edf"};

		for (String english : eng) {

			try {
				Integer.parseInt(english);

			} catch (NumberFormatException e) {
				System.out.println("NumberFormatException Integer.parseInt \""+ english +"\"");

			}
		}
	}
}