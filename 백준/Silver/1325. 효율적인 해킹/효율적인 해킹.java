import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static boolean[] visited;
	static Map<Integer, Integer> conn;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		conn = new HashMap<>();
		
		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<>());
			conn.put(i, 0);
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(to).add(from);
		}
		
		for (int i = 1; i <= N; ++i) {
			visited = new boolean[N + 1];
			dfs(i, i);
		}

		int maxValue = Collections.max(conn.values());
		
		for (int i = 1; i <= N; ++i) {
			if (conn.get(i) == maxValue) {
				sb.append(i).append(' ');
			}
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int start, int current) {
		visited[current] = true;
		
		for (int next : graph.get(current)) {
			if (!visited[next]) {
				conn.put(start, conn.get(start) + 1);
				dfs(start, next);
			}
		}
	}
}
