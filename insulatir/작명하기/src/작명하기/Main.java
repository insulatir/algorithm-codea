import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String S = scan.nextLine() + scan.nextLine();
		List<Integer> list = getPrefixSuffix(S);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		scan.close();
	}

	public static List<Integer> getPrefixSuffix(String s) {
		int[] pi = getPartialMatch(s);
		List<Integer> ret = new ArrayList<Integer>();
		int k = s.length();
		while (k > 0) {
			ret.add(k);
			k = pi[k-1];
		}
		
		return ret;
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
