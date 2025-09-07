import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static Deque<Integer> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() throws IOException {
		String cmd;
		int value = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			cmd = st.nextToken();
			
			if (st.hasMoreTokens()) {
				value = Integer.parseInt(st.nextToken());
			}
			
			switch (cmd) {
				case "push_front":
					dq.addFirst(value);
					
					break;
				case "push_back":
					dq.addLast(value);
					
					break;
				case "pop_front":
					if (!dq.isEmpty()) {
						sb.append(dq.pollFirst());
					} else {
						sb.append(-1);
					}
					sb.append('\n');
					
					break;
				case "pop_back":
					if (!dq.isEmpty()) {
						sb.append(dq.pollLast());
					} else {
						sb.append(-1);
					}
					sb.append('\n');
					
					break;
				case "size":
					sb.append(dq.size()).append('\n');
					
					break;
				case "empty":
					if (dq.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					sb.append('\n');
					
					break;
				case "front":
					if (dq.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(dq.peekFirst());
					}
					sb.append('\n');
					
					break;
				default:
					if (dq.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(dq.peekLast());
					}
					sb.append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
	}
}
