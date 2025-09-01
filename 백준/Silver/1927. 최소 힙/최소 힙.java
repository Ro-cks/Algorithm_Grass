import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < N; ++i) {
			int cmd = Integer.parseInt(br.readLine().trim());
			
			proc(cmd);
		}
	}
	
	static void proc(int cmd) {
		switch (cmd) {
			case 0:
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(pq.poll()).append('\n');
				}
				
				break;
			default:
				pq.offer(cmd);
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		pq = new PriorityQueue<>();
	}
}
