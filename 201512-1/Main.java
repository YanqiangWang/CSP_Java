import java.util.Scanner;

public class Main {

	private int sum;
	private long num;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		do {
			sum += num % 10;
			num /= 10;
		} while (num != 0);
		System.out.println(sum);
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		num = sc.nextLong();
		sc.close();
	}

}
