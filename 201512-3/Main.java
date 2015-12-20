import java.util.Scanner;

public class Main {

	private int m, n, q;
	private char[][] num;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.print();
	}

	private void print() {
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				System.out.print(num[i][j]);
			}
			System.out.println();
		}
	}

	private void fill(int x, int y, char c) {
		num[y][x] = c;
		if (x - 1 >= 0 && flag(num[y][x - 1]) && num[y][x - 1] != c) {
			fill(x - 1, y, c);
		}
		if (x + 1 < m && flag(num[y][x + 1]) && num[y][x + 1] != c) {
			fill(x + 1, y, c);
		}
		if (y - 1 >= 0 && flag(num[y - 1][x]) && num[y - 1][x] != c) {
			fill(x, y - 1, c);
		}
		if (y + 1 < n && flag(num[y + 1][x]) && num[y + 1][x] != c) {
			fill(x, y + 1, c);
		}
	}

	private boolean flag(char c) {
		return c != '|' && c != '-' && c != '+';
	}

	private void draw(int x1, int y1, int x2, int y2) {
		if (x2 < x1) {
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if (y2 < y1) {
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}
		if (x1 == x2) {
			for (int i = y1; i <= y2; i++) {
				if (num[i][x1] != '-') {
					num[i][x1] = '|';
				} else {
					num[i][x1] = '+';
				}
			}
		}
		if (y1 == y2) {
			for (int i = x1; i <= x2; i++) {
				if (num[y1][i] != '|') {
					num[y1][i] = '-';
				} else {
					num[y1][i] = '+';
				}
			}
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		q = sc.nextInt();
		num = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				num[i][j] = '.';
			}
		}
		for (int i = 0; i < q; i++) {
			if (sc.nextInt() == 1) {
				fill(sc.nextInt(), sc.nextInt(), sc.next().charAt(0));
			} else {
				draw(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
		}
		sc.close();
	}

}
