import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/1158/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; ++i) {
			deque.add(i);
		}
		
		sb.append('<');
		
		while (deque.size() > 1) {
			for (int i = 0; i < K - 1; ++i) {
				deque.add(deque.poll());
			}
			
			sb.append(deque.poll()).append(", ");
		}
		
		sb.append(deque.poll()).append('>');
		
		System.out.print(sb);
	}
}
