/* 6, 10, 3, 7, 4, 12, 2
 * 이전 값 이상이면 다 pop()
 * 이전 값보다 낮으면 sum += size()
 * 10 3 0 += 1
 * 10 7 pop
 * 10 7 4 1+=2
 * 10 12
 * 10 12 2 3+=2
 * 5
 * */
import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/6198
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		long answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; ++i) {
			int height = Integer.parseInt(br.readLine());
			
			if (stack.isEmpty()) {
				stack.push(height);
				
				continue;
			}
			
			if (stack.peek() <= height) {
				while (!stack.isEmpty() && stack.peek() <= height) {
					stack.pop();
				}
			}
			
			answer += stack.size();
			stack.push(height);
		}
		
		System.out.print(answer);
	}
}
