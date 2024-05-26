package Task_java_basic1;

public class Utility {

	/**
	 * 引数に指定した文字列がnull、または空文字かを判定します。
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 石の残数に応じて表示する"●"用のhtmlソースを生成します
	 * @return
	 */
	// todo:ここにgetStoneDisplayHtmlメソッドを定義
	public static String[] getStoneDisplayHtml(int totalNum) {
		int i = totalNum;
		String[] st = new String[i];
		for (int nums = 0; nums < i; nums++) {

			if (nums == 10 || nums == 20) {
				st[nums] = ("<br>●");
			} else {
				st[nums] = "●";
			}

		}

		return st;

	}

	//１ターン後にプレイヤーを切り替えるメソッド

	public static boolean change(String x) {
		if (x == null || x == "B") {

			return true;

		} else {

			return false;

		}
	}
}
