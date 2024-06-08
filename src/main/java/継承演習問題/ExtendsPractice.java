package 継承演習問題;

public class ExtendsPractice {

	public int id;
	public String content;

	public ExtendsPractice(int id, String content) {

		this.id = id;
		this.content = content;

	}

	@Override
	public String toString() {

		return "この単元は" + this.content + "が扱われます。LessonIDは" + this.id + "です。";

	}

}
//クラスを作成すると目視できないところで自動的にObjectクラスの継承が行われており(Objectクラスの自動生成）、また今回の場合だとtoString()は元々すべてのクラスのスーパークラスであるObjectクラスで定義されていることになり、
//toStringメソッドの「そのオブジェクトを文字列表現する機能」を使うことで文字列として返すことができる。
//また、アノテーションでオーバーライドと記述することによりこのような処理が実装可能になっている。
//つまり、ExtendsPracticeクラスはRunクラス（オブジェクトクラス）の子クラスに自動的に継承され、結果としてextendsを使用しなくともRunクラスのメソッドをExtendsPracticeはを継承したことになっている。