import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Point implements Comparable<Point> {
		int r;
		int c;
		int count;
		
		public Point(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
		
		@Override
		public int compareTo(Point o) {
			
			return this.count - o.count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static void solution() {		
		System.out.print(bfs());
	}
	
	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		
		pq.add(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			Point curr = pq.poll();
			
			if (curr.r == N - 1 && curr.c == N - 1) {

				return curr.count;
			}
			
			for (int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc]) continue;
				
				visited[nr][nc] = true;

				if (map[nr][nc] == 1) {
					pq.add(new Point(nr, nc, curr.count));
				} else {
					pq.add(new Point(nr, nc, curr.count + 1));
				}
			}
		}
		
		return 0;
	}
}
