import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int[] shifted = new int[50000];
	static int[] A = new int[50000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				shifted[j] = Integer.parseInt(arr[j]);
			}
			
			solve();
		}
		
		bw.flush();
		bw.close();
	}

	public static void solve() {
		Map<Integer, Integer> candidates = new TreeMap<Integer, Integer>();
		for (int i = 1; i <= n; i++) {
			candidates.put(i, i);
		}
		
		for (int i = n-1; i >= 0; i--) {
			int larger = shifted[i];
			
			int[] mapKeys = new int[candidates.size()];
			int pos = 0;
			for (int key : candidates.keySet()) {
			    mapKeys[pos++] = key;
			}
			int k = mapKeys[i - larger];
			A[i] = k;
			
			candidates.remove(k);
		}
	}
}
