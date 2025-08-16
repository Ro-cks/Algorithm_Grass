import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int V;
	static int E;
	static boolean isEven;
	static boolean[] group;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			for (int i = 1; i <= V; ++i) {
				if (isEven) {
					DFS(i);
				} else {
					break;
				}
			}
			
			if (isEven) sb.append("YES");
			else sb.append("NO");
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int start) {
		visited[start] = true;
		
		for (int node : graph[start]) {
			if (!visited[node]) {
				group[node] = !group[start];
				DFS(node);
			} else if (group[node] == group[start]) {
				isEven = false;
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		isEven = true;
		
		group = new boolean[V + 1];
		visited = new boolean[V + 1];
		
		graph = new ArrayList[V + 1];
		
		for (int i = 0; i <= V; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		
	}
}
