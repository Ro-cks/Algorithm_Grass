import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int R;
	static int C;
	static String answer;
	static int[] end;
	static int[] start;
	static char[][] map;
	static int[][] wDist;
	static int[][] sDist;
	static List<int[]> waters;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	static final String KAKTUS = "KAKTUS";
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		if (wDist[end[0]][end[1]] > sDist[end[0]][end[1]]) {
			answer = String.valueOf(sDist[end[0]][end[1]]);
		} else {
			answer = KAKTUS;
		}
		
		System.out.print(answer);
	}
	
	static void wBFS(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int cr = curr[0];
			int cc = curr[1];
			
			for (int[] dir : dirs) {
				int nr = cr + dir[0];
				int nc = cc + dir[1];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					
					continue;
				}
				
				if (map[nr][nc] == '.') {
					if (wDist[nr][nc] > wDist[cr][cc] + 1) {
						wDist[nr][nc] = wDist[cr][cc] + 1;
						
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
	static void sBFS(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int[] dir : dirs) {
				int nr = cr + dir[0];
				int nc = cc + dir[1];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					
					continue;
				}
				
				if (map[nr][nc] == '.' || map[nr][nc] == 'D') {
					if (wDist[nr][nc] > sDist[cr][cc] + 1 && sDist[nr][nc] > sDist[cr][cc] + 1) {
						sDist[nr][nc] = sDist[cr][cc] + 1;
						
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
	}
	
	static void solution() {
		Queue<int[]> queue = new LinkedList<>();
		for (int[] water : waters) {
			queue.offer(water);
		}
		
		wBFS(queue);
		
		queue.offer(start);
		sBFS(queue);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		wDist = new int[R][C];
		sDist = new int[R][C];
		waters = new ArrayList<>();
		
		for (int r = 0; r < R; ++r) {
			String input = br.readLine().trim();
			Arrays.fill(wDist[r], Integer.MAX_VALUE);
			Arrays.fill(sDist[r], Integer.MAX_VALUE);
			
			for (int c = 0; c < C; ++c) {
				char info = input.charAt(c);
				map[r][c] = info;
				
				if (info == '*') {
					waters.add(new int[] {r, c});
					wDist[r][c] = 0;
				}
				if (info == 'S') {
					start = new int[] {r, c};
					sDist[r][c] = 0;
				}
				if (info == 'D') {
					end = new int[] {r, c};
				}
			}
		}
	}
}
