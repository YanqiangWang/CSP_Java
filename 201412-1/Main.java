import java.util.Scanner;

public class Main {

	private int num;
	private int[] nums;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		int temp;
		for (int i = 0; i < num; i++) {
			temp = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] == nums[i]) {
					temp++;
				}
			}
			System.out.print(temp);
			if (i != num - 1) {
				System.out.print(" ");
			}
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		nums = new int[num];
		for (int i = 0; i < num; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
	}
}