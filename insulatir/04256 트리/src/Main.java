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
			
			printPostOrder(preorder, inorder);
			System.out.println();
		}
		
		scan.close();
	}

	public static void printPostOrder(int[] preorder, int[] inorder) {
		int N = preorder.length;
		if (N == 0) {
			return;
		}
		
		int root = preorder[0];
		int L = 0;
		for (int i = 0; i < N; i++) {
			if (inorder[i] == root) {
				L = i;
				break;
			}
		}
		
		printPostOrder(Arrays.copyOfRange(preorder, 1, L+1), Arrays.copyOfRange(inorder, 0, L));
		printPostOrder(Arrays.copyOfRange(preorder, L+1, N), Arrays.copyOfRange(inorder, L+1, N));
		System.out.print(root + " ");
	}
}
