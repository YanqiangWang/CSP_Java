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
		num = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == 0) {
						num++;
						nums[i] = 0;
						nums[j] = 0;
					}
				}
			}
		}
		System.out.println(num);
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		nums = new int[num];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
	}
}