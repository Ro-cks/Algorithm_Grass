import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int L = 2;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		
		dfs(0, 1);
		
		int answer = 0;
		
		for (int i = 2; i < visited.length; ++i) {
            if (visited[i]) {
                ++answer;
            }
        }
		
		System.out.print(answer);
	}
	
	public static void dfs(int depth, int point) {
		if (depth == 2) {
			
			return;
		}
		
		for (int i : graph.get(point)) {
			visited[i] = true;
			dfs(depth + 1, i);
		}
	}
}
