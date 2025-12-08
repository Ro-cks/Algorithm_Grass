import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int count;
	static int answer;
	static int[][] color;
	static boolean[][] map;
	
	static int[] dr = {-1, -1, 0, 1, 1, 0};
	static int[] dc = {0, 1, 1, 0, -1, -1};
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		count = 0;
		answer = 0;
		color = new int[N][N];
		map = new boolean[N][N];
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			Arrays.fill(color[i], -1);
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = input.charAt(j) == 'X';
				if (map[i][j]) ++count;
			}
		}
		
		if (count == 0) {
			System.out.print(0);
			
			System.exit(0);
		}
	}
	
	static void solution() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] && color[i][j] == -1) {
					bfs(i, j);
				}
			}
		}
		
		System.out.print(answer);
	}
	
	static void bfs(int sr, int sc) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(sr, sc));
		color[sr][sc] = 0;
		
		answer = Math.max(answer, 1);
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			for (int d = 0; d < 6; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (!map[nr][nc]) continue;
				
				if (color[nr][nc] == -1) {
					q.add(new Point(nr, nc));
					color[nr][nc] = 1 - color[curr.r][curr.c];
					
					answer = Math.max(answer, 2);
				} else if (color[nr][nc] == color[curr.r][curr.c]) {
					answer = Math.max(answer, 3);
				}
			}
		}
	}
}
