import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Point {
		int r;
		int c;
		int k;
		int dist;
		
		public Point(int r, int c, int k, int dist) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.dist = dist;
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
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static void solution() {
		int answer = bfs(0, 0);
		
		System.out.print(answer);
	}
	
	static int bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c, 0, 1));
		boolean[][][] visited = new boolean[N][M][K + 1];
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			if (curr.r == N - 1 && curr.c == M - 1) {
				
				return curr.dist;
			}
			
			for (int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc][curr.k]) continue;
				if (map[nr][nc] == 1) continue;
				
				visited[nr][nc][curr.k] = true;
				q.add(new Point(nr, nc, curr.k, curr.dist + 1));
			}
			
			if (curr.k < K) {
				for (int d = 0; d < 4; ++d) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if (map[nr][nc] == 1) {
						if (visited[nr][nc][curr.k + 1]) continue;
						
						visited[nr][nc][curr.k + 1] = true;
						q.add(new Point(nr, nc, curr.k + 1, curr.dist + 1));
					} else {
						if (visited[nr][nc][curr.k]) continue;
						
						visited[nr][nc][curr.k] = true;
						q.add(new Point(nr, nc, curr.k, curr.dist + 1));
					}
				}
			}
		}
		
		return -1;
	}
}
