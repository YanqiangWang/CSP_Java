import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[sc.nextInt()];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		int temp = num[0], times = 1;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != temp) {
				times++;
				temp = num[i];
			}
		}
		System.out.println(times);
		sc.close();
	}

}
