import java.util.Scanner;

public class Main {

	private int n, m;
	private int[][] nums;
	private int[][] click;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		for (int i = 0; i < m; i++) {
			boolean hasIt = false;
			for (int j = 0; j < n; j++) {
				if (click[i][0] >= nums[j][0] && click[i][1] >= nums[j][1] && click[i][0] <= nums[j][2]
						&& click[i][1] <= nums[j][3]) {
					System.out.println(nums[j][4]);
					move(j);
					hasIt = true;
					break;
				}
			}
			if (!hasIt) {
				System.out.println("IGNORED");
			}

		}
	}

	private void move(int pos) {
		int[][] temp = new int[1][5];
		for (int i = 0; i < 5; i++) {
			temp[0][i] = nums[pos][i];
		}
		for (int i = pos - 1; i >= 0; i--) {
			for (int j = 0; j < 5; j++) {
				nums[i + 1][j] = nums[i][j];
			}
		}
		for (int i = 0; i < 5; i++) {
			nums[0][i] = temp[0][i];
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n][5];
		click = new int[m][2];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				nums[i][j] = sc.nextInt();
			}
			nums[i][4] = n - i;
		}
		for (int i = 0; i < m; i++) {
			click[i][0] = sc.nextInt();
			click[i][1] = sc.nextInt();
		}
		sc.close();
	}
}