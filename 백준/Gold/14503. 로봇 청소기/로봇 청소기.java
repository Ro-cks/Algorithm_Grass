import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] map;
	static Cleaner c;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Cleaner {
		int r;
		int c;
		int d;
		
		public Cleaner(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
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
		
		st = new StringTokenizer(br.readLine().trim());
		int cleanR = Integer.parseInt(st.nextToken());
		int cleanC = Integer.parseInt(st.nextToken());
		int cleanD = Integer.parseInt(st.nextToken());
		c = new Cleaner(cleanR, cleanC, cleanD);
		
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
		
		while (true) {			
			int cr = c.r;
			int cc = c.c;
			
			if (map[cr][cc] == 0) {
				map[cr][cc] = 2;
				++answer;
			}
			
			boolean isCleanable = false;
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (map[nr][nc] == 0) {
					isCleanable = true;
				}
			}
			
			if (isCleanable) {
				c.d = (4 + (c.d - 1)) % 4;
				
				int nr = cr + dr[c.d];
				int nc = cc + dc[c.d];
				
				if (map[nr][nc] == 0) {
					c.r = nr;
					c.c = nc;
				}
			} else {
				int d = (c.d + 2) % 4;
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (map[nr][nc] != 1) {
					c.r = nr;
					c.c = nc;
				} else {
					break;
				}
			}
		}
		
		System.out.print(answer);
	}
}
