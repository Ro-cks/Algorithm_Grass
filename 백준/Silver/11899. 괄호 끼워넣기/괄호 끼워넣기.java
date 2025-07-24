import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for (char ch : input.toCharArray()) {
			if (stack.size() != 0) {
				if (stack.peek() == '(') {
					if (ch == ')') {
						stack.pop();
					} else {
						stack.push(ch);
					}
				} else {
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}
		
		System.out.print(stack.size());
	}
}
