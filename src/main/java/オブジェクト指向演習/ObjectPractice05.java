package オブジェクト指向演習;

public class ObjectPractice05 {
	public static void main(String[] args) {
		Parson parson = new Parson("佐藤", "北海道");

		System.out.println(parson.getSelfIntroduction());

		Parson parson1 = new Parson("伊藤", "岩手");

		System.out.println(parson1.getSelfIntroduction());

		Parson parson2 = new Parson("渡辺", "福島");

		System.out.println(parson2.getSelfIntroduction());

		Parson parson3 = new Parson("小林", "長野");

		System.out.println(parson3.getSelfIntroduction());

		Parson parson4 = new Parson("吉田", "新潟");

		System.out.println(parson4.getSelfIntroduction());

		Parson parson5 = new Parson("佐々木", "秋田");

		System.out.println(parson5.getSelfIntroduction());
	}

}
