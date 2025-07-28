import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		while (true) {
			Stack<Character> stack = new Stack<>();
			
			String input = br.readLine();
			if (input.equals(".")) {
				break;
			}
			
			boolean isNo = false;
			
			A: for (char ch : input.toCharArray()) {
				switch (ch) {
					case '(':
					case '[':
						stack.push(ch);
						break;
					case ')':
						if (!stack.isEmpty()) {
							if (stack.peek() == '(') {
								stack.pop();
							} else {
								isNo = true;
								
								break A;
							}
						} else {
							isNo = true;
							
							break A;
						}
						
						break;
					case ']':
						if (!stack.isEmpty()) {
							if (stack.peek() == '[') {
								stack.pop();
							} else {
								isNo = true;
								
								break A;
							}
						} else {
							isNo = true;
							
							break A;
						}
						
						break;
					default:
				}
			}
			
			if (!stack.isEmpty()) {
				sb.append("no").append('\n');
				
				continue;
			}
			
			if (isNo) {
				sb.append("no").append('\n');
			} else {
				sb.append("yes").append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
