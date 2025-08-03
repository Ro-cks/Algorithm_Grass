import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/3986
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		for (int i = 0; i < N; ++i) {
			String word = br.readLine();
			Deque<Character> stack = new ArrayDeque<>();
			
			for (char ch : word.toCharArray()) {
				if (!stack.isEmpty() && stack.peek() == ch) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
			
			if (stack.isEmpty()) {
				++answer;
			}
		}
		
		System.out.print(answer);
	}
}
