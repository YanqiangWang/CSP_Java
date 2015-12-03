import java.util.Scanner;

public class Main {
	private String input;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		char[] temp = input.toCharArray();
		int count = 0;
		int sum = 0;
		for (int i = 0; i < 12; i++) {
			if (temp[i] != '-') {
				count++;
				sum += toInt(temp[i]) * count;
			}
		}
		if (sum % 11 == toInt(temp[12])) {
			System.out.println("Right");
		} else {
			for (int i = 0; i < 12; i++) {
				System.out.print(temp[i]);
			}
			System.out.print(sum % 11 == 10 ? "X" : sum % 11);
		}
	}

	private int toInt(char c) {
		return c - '0';
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		sc.close();
	}

}