import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int C;
	static int R;
	static int r;
	static int c;
	static int[][] times;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		q = new LinkedList<>();
		times = new int[R][C];
		map = new char[R][C];
		
		r = 0;
		c = 0;
		for (int i = 0; i < R; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < C; ++j) {
				char val = input.charAt(j);
				
				if (val == 'F') {
					q.add(new int[] {i, j, 0});
					visited[i][j] = true;
				} else if (val == 'J') {
					r = i;
					c = j;
				}
				
				map[i][j] = val;
			}
		}
	}
	
	static void solution() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int time = curr[2];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == '#') continue;
				if (map[nr][nc] == 'F') continue;
				if (map[nr][nc] == 'J') continue;
				
				visited[nr][nc] = true;
				times[nr][nc] = time + 1;
				q.add(new int[] {nr, nc, time + 1});
			}
		}
		
		visited = new boolean[R][C];
		visited[r][c] = true;
		q.add(new int[] {r, c, 0});
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int time = curr[2];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					sb.append(time + 1).append('\n');
					
					return;
				}
				
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == '#') continue;
				if (times[nr][nc] != 0 && times[nr][nc] <= time + 1) continue;
				if (map[nr][nc] == 'F') continue;
				if (map[nr][nc] == 'J') continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, time + 1});
			}
		}
		
		sb.append("IMPOSSIBLE").append('\n');
	}
}
