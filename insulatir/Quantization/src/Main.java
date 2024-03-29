import java.util.*;
public class Main {
	static int n = 0;
	static int[] A;
	static int[][] cache = new int[101][11];
	static int[] pSum = new int[101];
	static int[] pSqSum = new int[101];
	static int INF = 987654321;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		for (int i = 0; i < C; i++) {
			n = scan.nextInt();
			int S = scan.nextInt();
			A = new int[n];
			for (int j = 0; j < n; j++) {
				A[j] = scan.nextInt();
			}
			for (int j = 0; j < 101; j++) {
				for (int k = 0; k < 11; k++) {
					cache[j][k] = -1;
				}
			}
			
			precalc();
			System.out.println(quantize(0, S));
		}
		
		scan.close();
	}
	
	public static void precalc() {
		Arrays.sort(A);
		pSum[0] = A[0];
		pSqSum[0] = A[0] * A[0];
		for (int i = 1; i < n; i++) {
			pSum[i] = pSum[i-1] + A[i];
			pSqSum[i] = pSqSum[i-1] + A[i] * A[i];
		}
	}
	
	public static int minError(int lo, int hi) {
		int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo-1]);
		int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo-1]);
		int m = (int) (0.5 + (double) sum / (double) (hi - lo + 1));
		int ret = sqSum - 2 * m * sum + m * m * (hi - lo + 1);
		return ret;
	}
	
	public static int quantize(int from, int parts) {
		if (from == n) {
			return 0;
		}
		
		if (parts == 0) {
			return INF;
		}
		
		if (cache[from][parts] != -1) {
			return cache[from][parts];
		}
		
		cache[from][parts] = INF;
		
		for (int partSize = 1; from + partSize <= n; partSize++) {
			cache[from][parts] = Math.min(cache[from][parts], minError(from, from + partSize - 1) + quantize(from + partSize, parts - 1));
		}
		
		return cache[from][parts];
	}
}
