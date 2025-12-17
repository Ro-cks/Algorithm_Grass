import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int T;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Point {
		int r;
		int c;
		int time;
		int hasSword;
		
		public Point(int r, int c, int time, int hasSword) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.hasSword = hasSword;
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
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		int answer = 0;
		
		answer = bfs();
		
		if (answer == -1) {
			System.out.print("Fail");
		} else {
			System.out.print(answer);
		}
	}
	
	static int bfs() {
		int answer = -1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0, 0));
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			if (curr.time > T) {
				
				break;
			}
			
			if (curr.r == N - 1 && curr.c == M - 1) {
				answer = curr.time;
				
				break;
			}
			
			for (int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc][curr.hasSword]) continue;
				
				if (curr.hasSword == 0) {
					if (map[nr][nc] == 1) continue;
				}
				
				visited[nr][nc][curr.hasSword] = true;
				
				if (map[nr][nc] == 2) {
					q.add(new Point(nr, nc, curr.time + 1, 1));
				} else {
					q.add(new Point(nr, nc, curr.time + 1, curr.hasSword));
				}
			}
		}
		
		return answer;
	}
}
