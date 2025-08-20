import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[][] map;
	static int[][] dist;
	static Queue<int[]> queue = new LinkedList<>();
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static int BFS() {
		int maxDays = 0;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int cr = curr[0];
			int cc = curr[1];
			
			maxDays = Math.max(maxDays, dist[cr][cc]);
			
			for (int[] dir : dirs) {
				int nr = cr + dir[0];
				int nc = cc + dir[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					
					continue;
				}
				
				if (map[nr][nc] == 0 && dist[nr][nc] == -1) {
					dist[nr][nc] = dist[cr][cc] + 1;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
		return maxDays;
	}
	
	// dist가 기본값인 곳은 접근할 수 없는 곳이다.
	static void solution() {
		answer = BFS();
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0 && dist[i][j] == -1) {
					answer = -1;
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		answer = 0;
		
		map = new int[N][M];
		dist = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				int tomato = Integer.parseInt(st.nextToken());
				map[i][j] = tomato;
				dist[i][j] = -1;
				
				if (tomato == 1) {
					queue.offer(new int[] {i, j});
					dist[i][j] = 0;
				}
			}
		}
	}
}
