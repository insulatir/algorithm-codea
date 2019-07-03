package 작명하기;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String S = scan.nextLine() + scan.nextLine();
		
		scan.close();
	}

	public static int[] getPartialMatch(String N) {
		int m = N.length();
		int[] pi = new int[m];
		int begin = 1;
		int matched = 0;
	}
}
