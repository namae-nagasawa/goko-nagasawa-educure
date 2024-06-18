package jp.co.sample.util;

public class Util {
	public static boolean isInt(String num) {
		
		try {
			num ="2147483648";
			Integer.parseInt(num);
			
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
