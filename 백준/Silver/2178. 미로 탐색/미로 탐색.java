import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] cost;
	static boolean[][] visited;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		BFS();
		
		
//		for (int i = 0; i < N; ++i) {
//			System.out.println(Arrays.toString(cost[i]));
//		}
		System.out.print(cost[N - 1][M - 1]);
	}
	
	static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];

			
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == 0) continue;
				
				cost[nr][nc] = cost[cr][cc] + 1;
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cost = new int[N][M];
		visited = new boolean[N][M];
		
		cost[0][0] = 1;
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
}
