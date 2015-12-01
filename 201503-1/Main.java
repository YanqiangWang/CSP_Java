import java.util.Scanner;

public class Main {

	private int rows, cols;
	private int[][] nums;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		for (int i = cols - 1; i >= 0; i--) {
			for (int j = 0; j < rows; j++) {
				System.out.print(nums[j][i]);
				if (j != rows - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		cols = sc.nextInt();
		nums = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				nums[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
}
