import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		int area = 2;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 1) {
					floodFill(i, j, area);
					++area;
				}
			}
		}
		
		int answer = 999;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] != 0) {
					answer = Math.min(answer, bfs(i, j));
				}
			}
		}
		
		System.out.print(answer);
	}
	
	static int bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c, 0, map[r][c]});
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		
		int min = 999;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int length = curr[2];
			int area = curr[3];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] == area) continue;
				
				if (map[nr][nc] != 0) {
					min = Math.min(min, length);
					
					return min;
				}
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, length + 1, area});
			}
		}
		
		return min;
	}
	
	static void floodFill(int r, int c, int area) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		map[r][c] = area;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] == 0) continue;
				
				map[nr][nc] = area;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
