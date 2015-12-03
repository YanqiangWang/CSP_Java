import java.util.Scanner;

public class Main {
	private int[] nums;
	int count = 0;
	int num = 0;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		for (int i = 0; i < nums.length; i++) {
			int temp_count = 0;
			int temp_num = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] != 0 && nums[j] != temp_num) {
					temp_num = nums[j];
					break;
				}
			}
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] != 0 && nums[j] == temp_num) {
					temp_count++;
					nums[j] = 0;
				}
			}
			if (temp_count > count || temp_count == count && temp_num < num) {
				count = temp_count;
				num = temp_num;
			}
		}
		System.out.println(num);
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		nums = new int[temp];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
	}
}