package メソッドプロジェクト;

public class Test {

	public static void main(String[] args) {

		int result =MethodPractice.tashizan(5,8);
		System.out.println(result);



		int str =MethodPractice.zero("0");
		System.out.println(str);

		MethodPractice.hyouzi("s", 3);

		MethodPractice.aisatsu();

		String mozi=MethodPractice.change(2.0);
		System.out.println(mozi);

		double answer=MethodPractice.split(10.0,2.0);
		System.out.println(answer);

		String a =MethodPractice.name();
		System.out.println(a);


		MethodPractice.fake(0);


		char two =MethodPractice.moji('a','i');
		System.out.println(two);

		MethodPractice.judge(7000);

		boolean hantei=MethodPractice.month(2000);
		System.out.println(hantei);

	}

}




