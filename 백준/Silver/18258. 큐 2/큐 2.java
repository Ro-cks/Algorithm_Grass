import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/18258/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static Deque<Integer> queue = new ArrayDeque<>();
	public static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		proc(N);
		
		System.out.print(sb);
	}
	
	public static void proc(int N) throws IOException {
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch(cmd) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					queue.add(num);
					break;
				case "pop":
					if (queue.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(queue.pop()).append('\n');
					}
					break;
				case "size":
					sb.append(queue.size()).append('\n');
					break;
				case "empty":
					if (queue.isEmpty()) {
						sb.append(1).append('\n');
					} else {
						sb.append(0).append('\n');
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(queue.peekFirst()).append('\n');
					}
					break;
				default:
					if (queue.isEmpty()) {
						sb.append(-1).append('\n');
					} else {
						sb.append(queue.peekLast()).append('\n');
					}
			}
		}
	}
}
