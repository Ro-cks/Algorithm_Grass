import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static List<Integer>[] conn;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		conn = new ArrayList[N * N];
		for (int i = 0; i < N * N; ++i) {
			conn[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			int u = x * N + y;
			int v = a * N + b;
			
			conn[u].add(v);
		}
	}
	
	static void solution() {
		int answer = 1;
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N * N];
		boolean[] light = new boolean[N * N];
		boolean[] canReach = new boolean[N * N];
		
		q.add(0);
		visited[0] = true;
		light[0] = true;
		canReach[0] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			for (int target : conn[curr]) {
				if (!light[target]) {
					light[target] = true;
					++answer;
					
					if (canReach[target] && !visited[target]) {
						visited[target] = true;
						q.add(target);
					}
				}
			}
			
			int r = curr / N;
			int c = curr % N;
			
			for (int d = 0; d < 4; ++d) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				int next = nr * N + nc;
				
				canReach[next] = true;
				
				if (light[next] && !visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
		System.out.print(answer);
	}
}
