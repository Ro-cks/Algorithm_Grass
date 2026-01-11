import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int m;
	static Point start;
	static int[][] map;
	static int[][] answer;
	static boolean[][] visited;
	
	static class Point {
		int r;
		int c;
		int dist;
		
		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		answer = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < m; ++j) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				
				if (val == 2) {
					start = new Point(i, j, 0);
				}
			}
		}
	}
	
	static void solution() {
		bfs(start.r, start.c);
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (visited[i][j]) {
					sb.append(answer[i][j]).append(' ');
				} else if (map[i][j] == 1) {
					sb.append("-1 ");
				} else {
					sb.append("0 ");
				}
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			int cr = curr.r;
			int cc = curr.c;
			int dist = curr.dist;
			answer[cr][cc] = dist;
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] == 0) continue;
				
				visited[nr][nc] = true;
				q.add(new Point(nr, nc, dist + 1));
			}
		}
	}
}
