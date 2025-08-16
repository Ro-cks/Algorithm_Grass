import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] D;	// 진입 차수 배열
	static List<Integer>[] graph;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
	}
    
	static void solution() {
		for (int i = 1; i <= N; ++i) {
			if (D[i] == 0) {
				queue.offer(i);
			}
		}
		
		BFS();
	}
	
	static void BFS() {
		while (!queue.isEmpty()) {
			int start = queue.poll();
			sb.append(start).append(' ');
			
			for (int next : graph[start]) {
				--D[next];
				
				if (D[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		D = new int[N + 1];
		graph = new ArrayList[N + 1];
		
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			++D[to];
			graph[from].add(to);
		}
	}
}
