import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	private static int width, height, q;
	private static char[][] num;
	private static ArrayDeque<Element> queue;

	public static void main(String[] args) {
		read_data();
		print();
	}

	public static void print() {
		for (int i = height - 1; i >= 0; i--) {
			for (int j = 0; j < width; j++) {
				System.out.print(num[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void fill(int w, int h, char temp) {
		char c = '*';
		if(temp == c)
			c = '&';
		Element elem = new Element(w, h);
		queue = new ArrayDeque<Element>();
		queue.addLast(elem);
		while(!queue.isEmpty()) {
			elem = queue.removeFirst();
			int y = elem.w;
			int x = elem.h;
			num[x][y] = c;
			if (0 <= x - 1 && flag(num[x - 1][y]) && num[x - 1][y] != c) {
				queue.addLast(new Element(y, x - 1));
			}
			if (0 <= y - 1 && flag(num[x][y - 1]) && num[x][y - 1] != c) {
				queue.addLast(new Element(y - 1, x));
			}
			if (x + 1 < height && flag(num[x + 1][y]) && num[x + 1][y] != c) {
				queue.addLast(new Element(y, x + 1));
			}
			if (y + 1 < width && flag(num[x][y + 1]) && num[x][y + 1] != c) {
				queue.addLast(new Element(y + 1, x));
			}
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (num[i][j] == c)
					num[i][j] = temp;
			}
		}
	}

	public static boolean flag(char c) {
		return c != '|' && c != '-' && c != '+';
	}

	public static void draw(int w1, int h1, int w2, int h2) {
		if (w2 < w1) {
			int temp = w1;
			w1 = w2;
			w2 = temp;
		}
		if (h2 < h1) {
			int temp = h1;
			h1 = h2;
			h2 = temp;
		}
		if (w1 == w2) {
			for (int i = h1; i <= h2; i++) {
				if (num[i][w1] != '-') {
					num[i][w1] = '|';
				} else {
					num[i][w1] = '+';
				}
			}
		}
		if (h1 == h2) {
			for (int i = w1; i <= w2; i++) {
				if (num[h1][i] != '|') {
					num[h1][i] = '-';
				} else {
					num[h1][i] = '+';
				}
			}
		}
	}

	public static void read_data() {
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();
		q = sc.nextInt();
		num = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
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

class Element {
	public int w, h;
	
	Element(int w, int h) {
		this.w = w;
		this.h = h;
	}
}
