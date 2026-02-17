import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int dustCount;
	static int w = -1;
	static int h = -1;
	static int[][] dustIdx;
	static char[][] map;
	static boolean[][][] visited;
	static Cleaner start;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Cleaner {
		int r;
		int c;
		int dist;
		int mask;
		
		public Cleaner(int r, int c, int dist, int mask) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.mask = mask;
		}
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine().trim());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		dustCount = 0;
		dustIdx = new int[h][w];
		map = new char[h][w];
		
		for (int i = 0; i < h; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < w; ++j) {
				char info = input.charAt(j);
				map[i][j] = info;
				
				if (info == '*') {
					dustIdx[i][j] = dustCount;
					++dustCount;
				} else if (info == 'o') {
					start = new Cleaner(i, j, 0, 0);
				}
			}
		}
	}
	
	static void solution() {
		int answer = bfs();
		sb.append(answer).append('\n');
	}
	
	static int bfs() {
		Queue<Cleaner> q = new LinkedList<>();
		visited = new boolean[h][w][1 << dustCount];
		q.offer(start);
		visited[start.r][start.c][0] = true;
		
		while (!q.isEmpty()) {
			Cleaner curr = q.poll();
			
			if (curr.mask == (1 << dustCount) - 1) {
				
				return curr.dist;
			}
			
			int cr = curr.r;
			int cc = curr.c;
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
				if (map[nr][nc] == 'x') continue;
				
				int nextMask = curr.mask;
				if (map[nr][nc] == '*') {
					nextMask |= (1 << dustIdx[nr][nc]);
				}
				
				if (visited[nr][nc][nextMask]) continue;
				visited[nr][nc][nextMask] = true;
				q.offer(new Cleaner(nr, nc, curr.dist + 1, nextMask));
			}
		}
		
		return -1;
	}
}
