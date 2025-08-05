import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/5397/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		Deque<Character> inputs = new ArrayDeque<>();
		Deque<Character> tmps = new ArrayDeque<>();
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			for (char ch : input.toCharArray()) {
				switch (ch) {
					case '<':
						if (inputs.isEmpty()) {
							continue;
						} else {
							tmps.push(inputs.pop());
						}
						break;
					case '>':
						if (tmps.isEmpty()) {
							continue;
						} else {
							inputs.push(tmps.pop());
						}
						break;
					case '-':
						if (inputs.isEmpty()) {
							continue;
						} else {
							inputs.pop();
						}
						break;
					default:
						inputs.push(ch);
				}
			}
			
			while (!tmps.isEmpty()) {
				inputs.push(tmps.pop());
			}
			
			while (!inputs.isEmpty()) {
				sb.append(inputs.pollLast());
			}
			
			System.out.println(sb);
		}
	}
}
