import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int n = scan.nextInt();
			int[] preorder = new int[n];
			int[] inorder = new int[n];
			for (int j = 0; j < n; j++) {
				preorder[j] = scan.nextInt();
			}
			for (int j = 0; j < n; j++) {
				inorder[j] = scan.nextInt();
			}
		}
		
		scan.close();
	}

	public static void printPostOrder(int[] preorder, int[] inorder) {
		int N = preorder.length;
	}
}
