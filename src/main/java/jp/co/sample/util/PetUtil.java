package jp.co.sample.util;

import jp.co.sample.pet.Animal;
import jp.co.sample.pet.Cat;
import jp.co.sample.pet.Dog;
import jp.co.sample.pet.Pet;


/**
 * Utilityメソッドをまとめたクラス
 */
public class PetUtil {

	/**
	 * 引数に指定した文字列がnull、または空文字かを判定
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		// このメソッドは作成済
		if (str == null || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 引数に指定した文字列が数値に変換できるかを判定
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		// このメソッドは作成済
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			return false;
		}

		return true;
	}

	/**
	 * 引数に指定した文字列が数値に変換して返却する。
	 * 変換できない場合はnullを返却する。
	 */
	public static Integer checkAndParseInt(String str) {
		// このメソッドは作成済
		if (isNumber(str)) {
			return Integer.parseInt(str);
		} else {
			return null;
		}
	}

	
	// todo: このメソッドの処理は作成済。必要なクラスがそろえばコメントアウトを戻せば良い。
	public static String getOptionTitleStr(Pet pet) {
		if (isDog(pet)) {
			return "散歩場所";
		} else if (isCat(pet)) {
			return "お気に入り遊具";
		} else {
			return "-";
		}
	}

	
	// todo: このメソッドの処理は作成済。必要なクラスがそろえばコメントアウトを戻せば良い。
	public static String getOptionStr(Pet pet) {
		if (isDog(pet)) {
			return ((Dog) pet).getWalkingPlace();
		} else if (isCat(pet)) {
			return ((Cat) pet).getFavoriteItem();
		} else {
			return "-";
		}
	}

	
	// todo: このメソッドの処理は作成済。必要なクラスがそろえばコメントアウトを戻せば良い。
	public static boolean isDog(Pet pet) {
		if (pet instanceof Dog) {
			return true;
		} else {
			return false;
		}
	}

	
	// todo: このメソッドの処理は作成済。必要なクラスがそろえばコメントアウトを戻せば良い。
	public static boolean isCat(Pet pet) {
		if (pet instanceof Cat) {
			return true;
		} else {
			return false;
		}
	}

	
	// todo: ※発展課題用。このメソッドの処理は作成済。必要なクラスがそろえばコメントアウトを戻せば良い。
	public static boolean isAnimal(Pet pet) {
		if (pet instanceof Animal) {
			return true;
		} else {
			return false;
		}
	}

	
	}

