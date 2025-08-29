import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static int answer;
	static char[][] map;
	static int[][] dTimes;
	static int[][] times;
	static Queue<int[]> dq;
	static Queue<int[]> q;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ');
			if (answer != 0) {
				sb.append(answer);
			} else {
				sb.append("GAME OVER");
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		devilBFS();
		
		BFS();
	}
	
	static void devilBFS() {
		while (!dq.isEmpty()) {
			int[] curr = dq.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 'D') continue;
				if (map[nr][nc] == 'X') continue;
				
				if (dTimes[nr][nc] > dTimes[cr][cc] + 1) {
					dTimes[nr][nc] = dTimes[cr][cc] + 1;
					
					dq.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	static void BFS() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			if (map[cr][cc] == 'D') {
				answer = times[cr][cc];
				
				return;
			}
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (dTimes[nr][nc] <= times[cr][cc] + 1) continue;
				if (map[nr][nc] == 'X') continue;
				if (map[nr][nc] == '*') continue;
				
				if (times[nr][nc] > times[cr][cc] + 1) {
					times[nr][nc] = times[cr][cc] + 1;
					
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new char[N][M];
		times = new int[N][M];
		dTimes = new int[N][M];
		
		dq = new LinkedList<>();
		q = new LinkedList<>();
		
		for (int i = 0; i < N; ++i) {
			Arrays.fill(dTimes[i], Integer.MAX_VALUE);
			Arrays.fill(times[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < M; ++j) {
				char ch = input.charAt(j);
				map[i][j] = ch;
				
				if (ch == '*') {
					dq.offer(new int[] {i, j});
					dTimes[i][j] = 0;
				} else if (ch == 'S') {
					q.offer(new int[] {i, j});
					times[i][j] = 0;
				}
			}
		}
	}
}
