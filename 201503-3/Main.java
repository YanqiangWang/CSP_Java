import java.util.Scanner;

public class Main {
	private int year1, year2;
	private int n_month, n_day, n_week;
	private int day_num;
	private int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		int n_week_first = year_num_first(year1 - 1);
		for (int i = year1; i <= year2; i++) {
			int month_n_first = month_num_first(is_leap_year(i), next_year_num_first(i - 1, n_week_first));
			n_week_first = next_year_num_first(i - 1, n_week_first);
			day_num = (n_week - 1) * 7 + n_day + 1 - month_n_first;
			if (n_day < month_n_first){
				day_num += 7;
			}
			boolean hasIt = true;
			if (day_num > months[n_month - 1]) {
				hasIt = false;
			}
			if (hasIt) {
				System.out.print(i + "/");
				if (n_month / 10 == 0) {
					System.out.print(0);
				}
				System.out.print(n_month + "/");
				if (day_num / 10 == 0) {
					System.out.print(0);
				}
				System.out.println(day_num);
			} else {
				System.out.println("none");
			}
		}
	}

	private int month_num_first(boolean is_leap, int year_first) {
		if (is_leap) {
			months[1] = 29;
		} else {
			months[1] = 28;
		}
		int temp_week_num = year_first;
		for (int i = 0; i < n_month - 1; i++) {
			temp_week_num = (temp_week_num + months[i]) % 7;
		}
		if (temp_week_num == 0) {
			temp_week_num = 7;
		}
		return temp_week_num;
	}

	private int next_year_num_first(int year, int week_num) {
		if (is_leap_year(year)) {
			week_num = (week_num + 366) % 7;
		} else {
			week_num = (week_num + 365) % 7;
		}
		if (week_num == 0) {
			week_num = 7;
		}
		return week_num;
	}

	private int year_num_first(int year) {
		int week_num = 2;
		if (year > 1850) {
			for (int i = 1850; i < year; i++) {
				if (is_leap_year(i)) {
					week_num = (week_num + 366) % 7;
				} else {
					week_num = (week_num + 365) % 7;
				}
			}
		} else if (year < 1850) {
			for (int i = 1850 - 1; i > year - 1; i--) {
				if (is_leap_year(i)) {
					week_num = (week_num - 366) % 7;
				} else {
					week_num = (week_num - 365) % 7;
				}
			}
		}
		if (week_num == 0) {
			week_num = 7;
		}
		return week_num;
	}

	private boolean is_leap_year(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		n_month = sc.nextInt();
		n_week = sc.nextInt();
		n_day = sc.nextInt();
		year1 = sc.nextInt();
		year2 = sc.nextInt();
		if (year1 > year2) {
			int temp = year1;
			year1 = year2;
			year2 = temp;
		}
		sc.close();
	}
}