import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/2161/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; ++i) {
			deque.add(i);
		}
		
		while (deque.size() > 1) {
			sb.append(deque.poll()).append(' ');
			deque.add(deque.poll());
		}
		
		sb.append(deque.poll());
		
		System.out.print(sb);
	}
}
