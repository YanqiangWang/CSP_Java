import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	String[] str;
	String[][] str2;

	public static void main(String[] args) {
		Main m = new Main();
		m.readDate();
		m.regex();
	}

	private void regex() {
		String regex;
		Pattern pat;
		Matcher m;
		for (int i = 0; i < str2.length; i++) {
			regex = "\\{\\{ " + str2[i][0] + " \\}\\}";
			pat = Pattern.compile(regex);
			for (int j = 0; j < str.length; j++) {
				m = pat.matcher(str[j]);
				str[j] = m.replaceAll(str2[i][1]);
			}
		}
		regex = "\\{\\{ .* \\}\\}";
		pat = Pattern.compile(regex);
		for (int i = 0; i < str.length; i++) {
			m = pat.matcher(str[i]);
			str[i] = m.replaceAll("");
		}
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	private void readDate() {
		Scanner sc = new Scanner(System.in);
		str = new String[sc.nextInt()];
		str2 = new String[sc.nextInt()][2];
		sc.nextLine();
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine();
		}
		for (int i = 0; i < str2.length; i++) {
			str2[i][0] = sc.next();
			str2[i][1] = sc.nextLine();
			str2[i][1] = str2[i][1].substring(2, str2[i][1].length() - 1);
		}
		sc.close();
	}

}
