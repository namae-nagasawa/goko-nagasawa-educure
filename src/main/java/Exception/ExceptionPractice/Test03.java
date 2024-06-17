package Exception.ExceptionPractice;

public class Test03 {
	public static void throwException() {
		throw new ExceptionPractice03();
	}

	public static void main(String[] args) {
		try {
			throwException();
		} catch (ExceptionPractice03 e) {
			System.out.println(e.getClass().getSuperclass());
		}
	}

}