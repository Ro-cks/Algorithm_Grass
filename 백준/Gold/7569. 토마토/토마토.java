import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int H;
	static int answer;
	static int[][][] dist;
	static int[][][] tomatoes;
	static Queue<int[]> queue = new LinkedList<>();
	
	static int[][] dirs = { {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1} };
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		answer = BFS();
		
		for (int h = 0; h < H; ++h) {
			for (int r = 0; r < N; ++r) {
				for (int c = 0; c < M; ++c) {
					if (tomatoes[h][r][c] == 0 && dist[h][r][c] == Integer.MAX_VALUE) {
						answer = -1;
					}
				}
			}
		}
	}
	
	static int BFS() {
		int maxDays = 0;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int ch = curr[0];
			int cr = curr[1];
			int cc = curr[2];
			
			maxDays = Math.max(maxDays, dist[ch][cr][cc]);
			
			for (int[] dir : dirs) {
				int nh = ch + dir[0];
				int nr = cr + dir[1];
				int nc = cc + dir[2];
				
				if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) {
					
					continue;
				}
				
				if (tomatoes[nh][nr][nc] != 0) {
					
					continue;
				}
				
				if (dist[nh][nr][nc] > dist[ch][cr][cc] + 1) {
					dist[nh][nr][nc] = dist[ch][cr][cc] + 1;
					queue.offer(new int[] {nh, nr, nc});
				}
			}
		}
		
		return maxDays;
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		dist = new int[H][N][M];
		tomatoes = new int[H][N][M];
		
		for (int h = 0; h < H; ++h) {
			for (int n = 0; n < N; ++n) {
				st = new StringTokenizer(br.readLine().trim());
				Arrays.fill(dist[h][n], Integer.MAX_VALUE);
				
				for (int m = 0; m < M; ++m) {
					int info = Integer.parseInt(st.nextToken());
					tomatoes[h][n][m] = info;
					
					if (info == 1) {
						dist[h][n][m] = 0;
						queue.offer(new int[] {h, n, m});
					}
				}
			}
		}
	}
}
