package オブジェクト指向演習;

public class Parson {
	public String name;
	public String from;

	public Parson(String name, String from) {
		this.name = name;
		this.from = from;
	}

	public String getSelfIntroduction() {
		return "私の名前は" + name + "です。" + from + "出身です。";
	}

}
