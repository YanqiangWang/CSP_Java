import java.util.Scanner;

public class Main {

	private int n;
	private int nums[];

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		n = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] - nums[j] == 1) {
					n++;
				}
			}
		}
		System.out.print(n);
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
	}
}