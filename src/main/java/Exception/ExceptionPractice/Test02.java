package Exception.ExceptionPractice;

public class Test02 {

	public Test02() {

	}

	public Test02(Throwable e) {

	}

	public static void throwException() throws ExceptionPractice02 {
		throw new ExceptionPractice02();
	}

	public static void main(String[] args) {

		//ExceptionPractice02 e = new ExceptionPractice02();

		try {
			throwException();
		} catch (ExceptionPractice02 e) {
			System.out.println(e.getClass().getSuperclass());
		}
	}
}
