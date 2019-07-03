import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		for (int i = 0; i < C; i++) {
			int N = scan.nextInt();
			int result = 0;
			String ori = scan.next();
			for (int j = 0; j < N; j++) {
				String tar = scan.next();
			}
		}
	}

	public static List<Integer> kmpSearch(String H, String N) {
		int n = H.length();
		int m = N.length();
		List<Integer> ret = new ArrayList<Integer>();
		int[] pi = getPartialMatch(N);
		int begin = 0;
		int matched = 0;
		while (begin <= n - m) {
			if (matched < m && H.charAt(begin + matched) == N.charAt(matched)) {
				
			}
		}
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
