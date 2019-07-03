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
		while (begin + matched < m) {
			if (N.charAt(begin + matched) == N.charAt(matched)) {
				matched += 1;
				pi[begin+matched-1] = matched;
			} else {
				if (matched == 0) {
					begin += 1;
				} else {
					begin += matched - pi[matched-1];
					matched = pi[matched-1];
				}
			}
		}
	}
}
