import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[] parents;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
	}
	
	static void solution() {
		BFS(1);
		
		for (int i = 2; i <= N; ++i) {
			sb.append(parents[i]).append('\n');
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int next : graph[curr]) {
				if (!visited[next]) {
					visited[next] = true;
					parents[next] = curr;
					queue.offer(next);
				}
			}
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		parents = new int[N + 1];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
	}
}
