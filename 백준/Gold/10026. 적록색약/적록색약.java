import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int answer1;
	static int answer2;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		map = new char[N][N];
		
		visited = new boolean[N][N];
		answer1 = 0;
		answer2 = 0;
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = input.charAt(j);
			}
		}
	}
	
	static void solution() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (visited[i][j]) continue;
				
				++answer1;
				commonBfs(i, j);
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (visited[i][j]) continue;
				
				++answer2;
				unCommonBfs(i, j);
			}
		}
		
		System.out.print(answer1 + " " + answer2);
	}
	
	static void commonBfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		char color = map[r][c];
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] != color) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
	
	static void unCommonBfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		char color = map[r][c];
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				if (color == 'R' || color == 'G') {
					if (map[nr][nc] == 'B') continue;
				} else {
					if (map[nr][nc] != color) continue;
				}
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
