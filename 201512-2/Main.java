import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static int height, width;
	public static int[][] num;
	public static ArrayDeque<Element> queue1, queue2;

	public static void main(String[] args) {
		read_data();
		process_data();
		print();
	}

	private static void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(num[i][j]);
				if (j != width - 1) 
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void process_data() {
		queue1 = new ArrayDeque<Element>();
		queue2 = new ArrayDeque<Element>();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (0 <= i - 1 && i + 1 < height && num[i][j] == num[i - 1][j] 
						&& num[i][j] == num[i + 1][j]) {
					queue1.addLast(new Element(i, j));
				}
				if (0 <= j - 1 && j + 1 < width && num[i][j] == num[i][j - 1]
						&& num[i][j] == num[i][j + 1]) {
					queue2.addLast(new Element(i, j));
				}
			}
		}
		Element elem;
		while(!queue1.isEmpty()) {
			elem = queue1.removeFirst();
			num[elem.h][elem.w] = 0;
			num[elem.h + 1][elem.w] = 0;
			num[elem.h - 1][elem.w] = 0;
		}
		while(!queue2.isEmpty()) {
			elem = queue2.removeFirst();
			num[elem.h][elem.w] = 0;
			num[elem.h][elem.w + 1] = 0;
			num[elem.h][elem.w - 1] = 0;
		}
	}

	public static void read_data() {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();
		width = sc.nextInt();
		num = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}

}

class Element {
	public int h, w;

	Element(int h, int w) {
		this.h = h;
		this.w = w;
	}
}
