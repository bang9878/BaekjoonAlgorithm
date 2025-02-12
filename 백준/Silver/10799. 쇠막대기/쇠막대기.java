import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		Stack<Character> stack = new Stack<>();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				if(str.charAt(i-1) == '(') {
					stack.pop();
					sum += stack.size();
				} else {
					stack.pop();
					sum++;
				}
			}
		}
		
		System.out.println(sum);
	}
}
