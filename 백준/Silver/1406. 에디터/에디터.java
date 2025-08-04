import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/1406/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static Deque<Character> inputs = new ArrayDeque<>();
	public static Deque<Character> tmp = new ArrayDeque<>();
	
	public static String input;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		input = br.readLine();
		for (char ch : input.toCharArray()) {
			inputs.push(ch);
		}
		
		N = Integer.parseInt(br.readLine());
		
		proc();
		
		while (!inputs.isEmpty()) {
			sb.append(inputs.pollLast());
		}
		
		System.out.print(sb);
	}
	
	public static void proc() throws IOException {
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			// a b c d x
			String cmd = st.nextToken();
			switch (cmd) {
				case "L":
					if (inputs.isEmpty()) {
						continue;
					} else {
						tmp.push(inputs.pop());
					}
					break;
				case "D":
					if (tmp.isEmpty()) {
						continue;
					} else {
						inputs.push(tmp.pop());
					}
					break;
				case "B":
					if (inputs.isEmpty()) {
						continue;
					} else {
						inputs.pop();
					}
					break;
				default:
					char ch = st.nextToken().charAt(0);
					inputs.push(ch);
			}
		}
		
		while (!tmp.isEmpty()) {
			inputs.push(tmp.pop());
		}
	}
}
