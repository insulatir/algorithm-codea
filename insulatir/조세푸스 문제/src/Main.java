import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		for (int i = 0; i < C; i++) {
			int N = scan.nextInt();
			int K = scan.nextInt();
			
			josephus(N, K);
		}
		
		scan.close();
	}

	public static void josephus(int n, int k) {
		List<Integer> survivors = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			survivors.add(i);
		}
		
		int kill = 0;
		while (survivors.size() > 2) {
			survivors.remove(kill);
			if (kill >= survivors.size()) {
				kill = 0;
			}
			
			for (int i = 0; i < k-1; i++) {
				kill += 1;
				if (kill >= survivors.size()) {
					kill = 0;
				}
			}
		}
		
		System.out.println(survivors.get(0) + " " + survivors.get(1));
	}
}
