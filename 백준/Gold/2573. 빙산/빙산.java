import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	
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
		map = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		int answer = 0;
		
		while (true) {

			int count = countIsland();
			
			if (count >= 2) {
				System.out.print(answer);
				
				break;
			}
			
			if (count == 0) {
				System.out.print(0);
				
				break;
			}
			
			melt();
			++answer;
		}
	}
	
	static void melt() {
		int[][] result = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				
				if (map[i][j] > 0) {
					int seaCount = 0;
					
					for (int d = 0; d < 4; ++d) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						
						if (map[nr][nc] <= 0) ++seaCount;
					}
					
					result[i][j] = seaCount;
				}
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				map[i][j] -= result[i][j];
				if (map[i][j] < 0) map[i][j] = 0;
			}
		}
	}
	
	static int countIsland() {
		int count = 0;
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] > 0 && !visited[i][j]) {
					bfs(i, j);
					++count;
				}
			}
		}
		
		return count;
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] > 0) {
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}
}
