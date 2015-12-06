import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	private String regex;
	private int isSensitive, lines;
	private String[] ex;

	public static void main(String[] args) {
		Main m = new Main();
		m.read_data();
		m.process_data();
	}

	private void process_data() {
		if (isSensitive == 0) {
			regex = "(?i)" + regex;
		}
		Pattern pat = Pattern.compile(regex);
		Matcher mc = null;
		for (int i = 0; i < ex.length; i++) {
			mc = pat.matcher(ex[i]);
			while (mc.find()) {
				System.out.println(ex[i]);
				break;
			}
		}

	}

	private void read_data() {
		Scanner sc = new Scanner(System.in);
		regex = sc.nextLine();
		isSensitive = sc.nextInt();
		lines = sc.nextInt();
		ex = new String[lines];
		sc.nextLine();
		for (int i = 0; i < ex.length; i++) {
			ex[i] = sc.nextLine();
		}
		sc.close();
	}
}