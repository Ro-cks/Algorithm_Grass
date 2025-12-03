import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int w;
	static int h;
	static int r;
	static int c;
	static int[][] times;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; ++t) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		visited = new boolean[h][w];
		q = new LinkedList<>();
		times = new int[h][w];
		map = new char[h][w];
		
		r = 0;
		c = 0;
		for (int i = 0; i < h; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < w; ++j) {
				char val = input.charAt(j);
				
				if (val == '*') {
					q.add(new int[] {i, j, 0});
					visited[i][j] = true;
				} else if (val == '@') {
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
				
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == '#') continue;
				if (map[nr][nc] == '*') continue;
				if (map[nr][nc] == '@') continue;
				
				visited[nr][nc] = true;
				times[nr][nc] = time + 1;
				q.add(new int[] {nr, nc, time + 1});
			}
		}
		
		visited = new boolean[h][w];
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
				
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
					sb.append(time + 1).append('\n');
					
					return;
				}
				
				if (visited[nr][nc]) continue;
				if (map[nr][nc] == '#') continue;
				if (times[nr][nc] != 0 && times[nr][nc] <= time + 1) continue;
				if (map[nr][nc] == '*') continue;
				if (map[nr][nc] == '@') continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, time + 1});
			}
		}
		
		sb.append("IMPOSSIBLE").append('\n');
	}
}
