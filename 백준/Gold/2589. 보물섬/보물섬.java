import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R;
	static int C;
	static char[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < C; ++j) {
				map[i][j] = input.charAt(j);
			}
		}
	}
	
	static void solution() {
		int answer = 0;
		
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] == 'L') {
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}
		
		System.out.print(answer);
	}
	
	static int bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c, 0});
		boolean[][] visited = new boolean[R][C];
		visited[r][c] = true;
		
		int distance = 0;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			distance = Math.max(distance, curr[2]);
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] == 'W') continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, curr[2] + 1});
			}
		}
		
		return distance;
	}
}
