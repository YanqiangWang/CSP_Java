import java.util.Scanner;

public class Main {

	private int[][] roads;
	private int count;
	private int points;
	private int[] way;
	private int times;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		for (int i = 0; i < points; i++) {
			times = 0;
			way[0] = i + 1;
			next(way[0]);
			if (times == count) {
				for (int j = 0; j < way.length; j++) {
					System.out.print(way[j]);
					if (j != way.length - 1) {
						System.out.print(" ");
					}
				}
				return;
			}
		}
		System.out.print(-1);
	}

	private boolean next(int pos) {
		int temp_pos = 0;
		boolean canGo = false;
		boolean help = true;
		for (int i = 0; i < count; i++) {
			if (roads[2][i] != 0) {
				canGo = true;
				int min = count + 1;
				if (roads[0][i] == pos) {
					if (roads[0][i] < min) {
						min = roads[0][i];
						temp_pos = i;
						help = true;
					}
				}
				if (roads[1][i] == pos) {
					if (roads[1][i] < min) {
						min = roads[1][i];
						temp_pos = i;
						help = false;
					}
				}
				if (min != count + 1) {
					times++;
					if (help) {
						way[times] = roads[1][temp_pos];
					} else {
						way[times] = roads[0][temp_pos];
					}
					roads[2][i] = 0;
					boolean temp = next(way[times]);
					if (!temp) {
						if (times == count) {
							return false;
						} else {
							times--;
							continue;
						}
					}
				}
			}
		}
		if (!canGo) {
			return false;
		} else {
			way[times] = 0;
			times--;
			return true;
		}
	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		points = sc.nextInt();
		count = sc.nextInt();
		way = new int[count + 1];
		roads = new int[3][count];
		for (int i = 0; i < count; i++) {
			roads[0][i] = sc.nextInt();
			roads[1][i] = sc.nextInt();
			roads[2][i] = 1;
		}
		sc.close();
	}

}
