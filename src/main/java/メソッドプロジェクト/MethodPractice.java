package メソッドプロジェクト;

public class MethodPractice {


	public static int tashizan(int x ,int y) {
		return x+y;

	}
	public static int zero(String n) {
		return Integer.parseInt(n);
	}
	public static void hyouzi(String a, int b) {
		for(int i =0;i<b;i++) {

			System.out.print(a);

		}
		System.out.println("");
	}
	public static void aisatsu(String c) {
		System.out.println(c);
	}
	public static String change(double d) {
		return String.valueOf(d);
	}
	public static double split(double v ,double j) {
		return v/j;
	}
	public static String name() {
		String a ="goko";
		return a;
	}
	public static void fake(int h) {
		if(h==0) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}
	public static char moji(char j,char d) {
		return 'j'+'d';
	}
	public static void judge(int i) {
		if(i<=299) {
			System.out.println(5);
		}else if(300 <=i && i<= 999){
			System.out.println(15);
		}else if(1000<=i && i <=4999){
			System.out.println(30);
		}else if(5000<=i){
			System.out.println(50);
		}

	}
	public static boolean month(int p) {

		if(p % 400 == 0 || (p % 100 != 0 && p % 4 == 0)){
			return true;
		}else {
			return false;
		}
	}
}




	

	



