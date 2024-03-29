import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String S = scan.next();
		System.out.println(maxOverlap(S, (new StringBuffer(S)).reverse().toString()));
		
		scan.close();
	}

	public static int maxOverlap(String a, String b) {
		int n = a.length();
		int m = b.length();
		int[] pi = getPartialMatch(b);
		int begin = 0;
		int matched = 0;
		while (begin < m) {
			if (matched < m && a.charAt(begin + matched) == b.charAt(matched)) {
				matched += 1;
				if (begin + matched == n) {
					return matched + (n-matched)*2;
				}
			} else {
				if (matched == 0) {
					begin += 1;
				} else {
					begin += matched - pi[matched-1];
					matched = pi[matched-1];
				}
			}
		}
		
		return 2*n;
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
		
		return pi;
	}
}
