import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int K;
	static int W;
	static int H;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] hdr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hdc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static class Point {
		int r;
		int c;
		int count;
		int k;
		
		public Point(int r, int c, int count, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		K = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < W; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		int answer = bfs(0, 0);
		
		System.out.print(answer);
	}
	
	static int bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0, 0));
		boolean[][][] visited = new boolean[H][W][K + 1];
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			if (curr.r == H - 1 && curr.c == W - 1) {
				
				return curr.count;
			}
			
			for (int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				int nk = curr.k;
				
				if (isOutOfBound(nr, nc)) continue;
				if (map[nr][nc] == 1) continue;
				if (visited[nr][nc][nk]) continue;
				
				visited[nr][nc][nk] = true;
				q.add(new Point(nr, nc, curr.count + 1, nk));
			}
			
			if (curr.k < K) {
				for (int d = 0; d < 8; ++d) {
					int nr = curr.r + hdr[d];
					int nc = curr.c + hdc[d];
					int nk = curr.k + 1;
					
					if (isOutOfBound(nr, nc)) continue;
					if (map[nr][nc] == 1) continue;
					if (visited[nr][nc][nk]) continue;
					
					visited[nr][nc][nk] = true;
					q.add(new Point(nr, nc, curr.count + 1, nk));
				}
			}
		}
		
		return -1;
	}
	
	static boolean isOutOfBound(int r, int c) {
		if (r < 0 || r >= H || c < 0 || c >= W) {
			
			return true;
		}
		
		return false;
	}
}
