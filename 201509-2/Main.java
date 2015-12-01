import java.util.Scanner;

public class Main {

	private int year, day;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean isLeap = false;
		if (year % 4 == 0 && year % 100 != 0) {
			isLeap = true;
		} else if (year % 400 == 0) {
			isLeap = true;
		}
		if (isLeap) {
			months[1] = 29;
		}
		int temp_day = day;
		for (int i = 0; i < months.length; i++) {
			if (temp_day - months[i] > 0) {
				temp_day -= months[i];
			} else {
				System.out.println(i + 1);
				System.out.println(temp_day);
				break;
			}
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		year = sc.nextInt();
		day = sc.nextInt();
		sc.close();
	}
}
