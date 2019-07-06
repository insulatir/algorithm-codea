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
			
		}
		
		bw.flush();
		bw.close();
	}

}
