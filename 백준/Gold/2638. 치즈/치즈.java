import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int cheeseCount = 0;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
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
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) ++cheeseCount;
			}
		}
	}
	
	static void solution() {
		int answer = 0;
		
		while (cheeseCount > 0) {
			++answer;
			
			boolean[][] isOutsideAir = airBfs();
			
			List<Point> meltingList = new ArrayList<>();
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (map[i][j] == 1) {
						if (canMelt(i, j, isOutsideAir)) {
							meltingList.add(new Point(i, j));
						}
					}
				}
			}
			
			for (Point p : meltingList) {
				map[p.r][p.c] = 0;
				--cheeseCount;
			}
		}
		
		System.out.print(answer);
	}
	
	static boolean[][] airBfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new ArrayDeque<>();
		
		q.add(new Point(0, 0));
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			for (int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
		
		return visited;
	}
	
	static boolean canMelt(int r, int c, boolean[][] outsideAir) {
		int count = 0;
		
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			if (outsideAir[nr][nc]) ++count;
		}
		
		return count >= 2;
	}
}
