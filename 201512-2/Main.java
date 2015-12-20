import java.util.Scanner;

public class Main {

	private int n, m;
	private int[][] num, out;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		search1();
		search2();
		print_num();
	}

	private void search2() {
		int temp;
		int count = 1;
		for (int j = 0; j < m; j++) {
			temp = num[0][j];
			for (int i = 0; i < n; i++) {
				if (i == 0) {
					continue;
				}
				if (temp == num[i][j]) {
					count++;
				}
				if (count > 2)
					if (temp != num[i][j] || i == n - 1) {
						count = 1;
						for (int k = i; k >= 0; k--) {
							if (temp == num[k][j]) {
								out[k][j] = 0;
							}
						}
					}
				temp = num[i][j];
			}
			count = 1;
		}
	}

	private void print_num() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(out[i][j]);
				if (j != m - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private void search1() {
		int temp;
		int count = 1;
		for (int i = 0; i < n; i++) {
			temp = num[i][0];
			for (int j = 0; j < m; j++) {
				if (j == 0) {
					continue;
				}
				if (temp == num[i][j]) {
					count++;
				}
				if (count > 2)
					if (temp != num[i][j] || j == m - 1) {
						count = 1;
						for (int k = j; k >= 0; k--) {
							if (temp == num[i][k]) {
								out[i][k] = 0;
							}
						}
					}
				temp = num[i][j];
			}
			count = 1;
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n][m];
		out = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				out[i][j] = num[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}

}
