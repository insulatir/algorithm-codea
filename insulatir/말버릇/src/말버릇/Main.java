import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		for (int i = 0; i < C; i++) {
			int K = scan.nextInt();
			String s = scan.next();
		}
		
		scan.close();
	}
	
	public static int longestFrequent(int k, String s) {
		Integer[] a = getSuffixArray(s);
		int ret = 0;
		for (int i = 0; i + k <= s.length(); i++) {
			ret = Math.max(ret, commonPrefix(s, a[i], a[i + k - 1]));
		}
		
		return ret;
	}
	
	public static int commonPrefix(String s, int i, int j) {
		int k = 0;
		while (i < s.length() && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i += 1;
			j += 1;
			k += 1;
		}
		
		return k;
	}
	
	public static Integer[] getSuffixArray(String s) {
		int n = s.length();
		int t = 1;
		int[] group = new int[n+1];
		for (int i = 0; i < n; i++) {
			group[i] = s.charAt(i);
		}
		group[n] = -1;
		Integer[] perm = new Integer[n];
		for (int i = 0; i < n; i++) {
			perm[i] = i;
		}
		while (t < n) {
			Arrays.sort(perm, new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					if (group[a] != group[b]) {
						return Integer.compare(group[a], group[b]);
					}
					return Integer.compare(group[a + t], group[b + t]);
				}
			});
			
			t *= 2;
			if (t >= n) {
				break;
			}
			
			int[] newGroup = new int[n+1];
			newGroup[n] = -1;
			newGroup[perm[0]] = 0;
			for (int i = 1; i < n; i++) {
				if (group[perm[i-1]] < group[perm[i]] || (group[perm[i-1]] == group[perm[i]] && group[perm[i-1] + t] < group[perm[i] + t])) {
					newGroup[perm[i]] = newGroup[perm[i-1]] + 1;
				} else {
					newGroup[perm[i]] = newGroup[perm[i-1]];
				}
			}
			group = newGroup;
		}
		
		return perm;
	}
}
