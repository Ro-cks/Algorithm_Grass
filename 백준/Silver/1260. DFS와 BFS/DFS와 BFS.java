import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int V;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		init();
		
		DFS(V);
		sb.append('\n');
		
		visited = new boolean[N + 1];
		BFS();
		
		System.out.print(sb);
	}
	
	static void DFS(int from) {
		if (from == N + 1) {
			
			return;
		}
		
		sb.append(from).append(' ');
		visited[from] = true;		
		for (int to : graph[from]) {
			if (!visited[to]) {
				visited[to] = true;
				DFS(to);
			}
		}
	}
	
	static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			visited[curr] = true;
			sb.append(curr).append(' ');
			
			for (int next : graph[curr]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
			Collections.sort(graph[from]);
			Collections.sort(graph[to]);
		}
	}
}
