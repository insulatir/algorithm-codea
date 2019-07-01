import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		for (int i = 0; i < C; i++) {
			int N = scan.nextInt();
			int K = scan.nextInt();
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
		}
	}
}
