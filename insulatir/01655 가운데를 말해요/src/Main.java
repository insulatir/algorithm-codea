import java.util.*;
public class Main {
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		scan.close();
	}

	public static void runningMedian(int n) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
		for (int cnt = 1; cnt <= n; cnt++) {
			if (maxHeap.size() == minHeap.size()) {
				maxHeap.add(scan.nextInt());
			} else {
				minHeap.add(scan.nextInt());
			}
		}
	}
}
