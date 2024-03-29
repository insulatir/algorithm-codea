import java.util.Scanner;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] array = new int[n];
		int[] len = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			if(len[i] == 0) {
				len[i] = 1;
			}
			
			for(int j = 0; j < i; j++) {
				if(array[i] > array[j]) {
					if(len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
					}
				}
			}
		}
		
		Arrays.sort(len);
		System.out.print(len[len.length-1]);
		
		scan.close();
	}

}
