import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		stack = new Stack<>();
	}
	
	static void solution() throws IOException {
		int answer = 0;
		int input = 0;
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			st.nextToken();
			
			input = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty() && stack.peek() > input) {
				stack.pop();
				++answer;
			}
			
			if (input == 0) continue;
			
			if (stack.isEmpty() || stack.peek() < input) {
				stack.push(input);
			}
		}
		
		answer += stack.size();
		
		System.out.print(answer);
	}
}
