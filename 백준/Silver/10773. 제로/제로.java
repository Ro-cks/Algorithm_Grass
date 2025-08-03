import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/10773
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int K = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < K; ++i) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {
				stack.pop();
			} else {
				stack.push(input);
			}
		}
		
		int answer = 0;
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		
		System.out.print(answer);
	}
}
