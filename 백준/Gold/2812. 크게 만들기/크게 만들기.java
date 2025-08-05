import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/2812/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		String input = br.readLine();
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < N; ++i) {
			 int num = input.charAt(i) - '0';
			 
			 if (stack.isEmpty()) {
				 stack.push(num);
			 } else {
				 while (!stack.isEmpty() && count > 0 && stack.peek() < num) {
					 stack.pop();
					 --count;
				 }
				 
				 stack.push(num);
			 }
		}
		
		while (count > 0) {
			stack.pop();
			--count;
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.print(sb.reverse());
	}
}
