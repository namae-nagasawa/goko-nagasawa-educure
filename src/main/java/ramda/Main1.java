package ramda;

import java.util.Arrays;
import java.util.List;

public class Main1 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 5, 2, 20, 12, 15);
		int[] sum = { 0 };

		numbers.forEach(data -> sum[0] += data);
		System.out.println(sum[0]);

	}

}