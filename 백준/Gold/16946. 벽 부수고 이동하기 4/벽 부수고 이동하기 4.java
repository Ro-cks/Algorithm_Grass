import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static Map<Integer, Integer> sizes;
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
		
		sizes = new HashMap<>();
		
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static void solution() {
		int[][] answer = new int[N][M];
		
		int group = 2;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) {
					sizes.put(group, bfs(i, j, group));
					++group;
				}
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 1) {
					int sum = 1;
					Set<Integer> set = new HashSet<>();
					
					for (int d = 0; d < 4; ++d) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						if (map[nr][nc] == 1) continue;
						
						if (set.contains(map[nr][nc])) continue;
						
						set.add(map[nr][nc]);
						sum += sizes.get(map[nr][nc]);
					}
					sb.append(sum % 10);
				} else {
					sb.append(0);
				}
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static int bfs(int r, int c, int group) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		map[r][c] = group;
		int size = 0;
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			++size;
			
			for (int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] != 0) continue;
				
				map[nr][nc] = group;
				q.add(new Point(nr, nc));
			}
		}
		
		return size;
	}
}
