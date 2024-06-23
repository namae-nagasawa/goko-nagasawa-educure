
public class Main {

	public static void main(String[] args) {
		Process process = new Process();

		System.out.println(process.getStatus());

		process.progress();

		System.out.println(process.getStatus());

		process.progress();

		System.out.println(process.getStatus());

	}
}
