import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int count;
	static int answer;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(0);
	}
	
	static void solution() {
        for (int i = 0; i < N; ++i) {
            visited[i] = true;
            DFS(i, 0);
            visited[i] = false;
        }
	}
	
	static void DFS(int curr, int depth) {
		if (depth == 4) {
			
			System.out.print(1);
			
			System.exit(0);
		}
		
		for (int next : graph[curr]) {
			if (!visited[next]) {
				visited[next] = true;
				DFS(next, depth + 1);
				visited[next] = false;
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		graph = new ArrayList[N];
		
		for (int i = 0; i < N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
	}
}
