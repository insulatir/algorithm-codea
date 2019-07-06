import java.util.*;
import java.io.*;
public class Main {
	static int n;

	public static void main(String[] args) {
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
