import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		for (int i = 0; i < C; i++) {
			String formula = scan.next();
		}
		
		scan.close();
	}

	public static boolean wellMatched(String formula) {
		String opening = "({[";
		String closing = ")}]";
		Stack<Character> openStack = new Stack<Character>();
		for (int i = 0; i < formula.length(); i++) {
			if (opening.indexOf(formula.charAt(i)) != -1) {
				openStack.push(formula.charAt(i));
			} else {
				if (openStack.empty()) {
					return false;
				}
				
				if (opening.indexOf(openStack.peek()) != closing.indexOf(formula.charAt(i))) {
					return false;
				}
				
				openStack.pop();
			}
		}
	}
}
