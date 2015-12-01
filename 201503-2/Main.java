import java.util.Scanner;

public class Main {

	private int num;
	private int[] arrays;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		int[][] count = new int[2][num];
		int times = 1;
		count[0][0] = arrays[0];
		count[1][0] = 0;
		boolean hasNum = false;
		for (int array : arrays) {
			for (int i = 0; i < times; i++) {
				if (array == count[0][i]) {
					count[1][i]++;
					hasNum = true;
				}
			}
			if (!hasNum) {
				count[0][times] = array;
				count[1][times] = 1;
				times++;
			}
			hasNum = false;
		}
		int max = 0;
		int max_num = 0;
		int loc = 0;
		boolean isContinue = true;
		while (isContinue) {
			for (int i = 0; i < times; i++) {
				if (count[1][i] > max || (count[1][i] == max && count[0][i] < max_num)) {
					max = count[1][i];
					max_num = count[0][i];
					loc = i;
				}
			}
			if (max != 0) {
				System.out.println(max_num + " " + max);
			} else {
				isContinue = false;
			}
			max = 0;
			max_num = 0;
			count[0][loc] = 0;
			count[1][loc] = 0;
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		arrays = new int[num];
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = sc.nextInt();
		}
		sc.close();
	}
}