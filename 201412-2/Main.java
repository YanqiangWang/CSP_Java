import java.util.Scanner;

public class Main {
	private static int length;
	private static int num[][];

	public static void main(String[] args) {
		read_data();
		process_data();
	}

	private static void process_data() {
		for (int i = 0; i < length * 2 - 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (i - j < length && j < length) {
					if (i != 0 || j != 0)
						System.out.print(" ");
					if (i % 2 == 0)
						System.out.print(num[i - j][j]);
					else
						System.out.print(num[j][i - j]);
				}
			}
		}
	}

	private static void read_data() {
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();
		num = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
}
