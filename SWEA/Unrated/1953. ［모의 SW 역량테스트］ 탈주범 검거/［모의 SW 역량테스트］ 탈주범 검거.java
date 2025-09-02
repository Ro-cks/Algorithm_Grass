import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int answer;
	static int[][] map;
	static int[][] time;
	static Queue<int[]> q;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] conn = { {1, 1, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}, {1, 0, 1, 0} };
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
//		
//		for (int i = 0; i < N; ++i) {
//			System.out.println(Arrays.toString(time[i]));
//		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			++answer;
			
		for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 0) continue;
				if (!isConn(map[cr][cc], map[nr][nc], d)) continue;
				
				if (time[cr][cc] + 1 > L) break;
				
				if (time[nr][nc] > time[cr][cc] + 1) {
					time[nr][nc] = time[cr][cc] + 1;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	/* 다음 칸: 남, 북, 동, 서
	 * 1, 0: 2, 4, 7
	 * 1, 1: 2, 5, 6
	 * 1, 2: 3, 6, 7
	 * 1, 3: 3, 4, 5
	 * 
	 * 2, 0: 1, 4, 7
	 * 2, 1: 1, 5, 6
	 * 2, 2: 
	 * 2, 3: 
	 * 
	 * 3, 0: 
	 * 3, 1: 
	 * 3, 2: 1, 6, 7
	 * 3, 3: 1, 4, 5
	 * 
	 * 4, 0: 1, 2, 5, 6
	 * 4, 1: 
	 * 4, 2: 1, 3, 6, 7
	 * 4, 3: 
	 * 
	 * 5, 0: 1, 2, 4, 7
	 * 5, 1: 
	 * 5, 2: 1, 3, 6, 7
	 * 5, 3: 
	 * 
	 * 6, 0: 1, 2, 4, 7
	 * 6, 1: 
	 * 6, 2: 
	 * 6, 3: 1, 3, 4, 5
	 * 
	 * 7, 0: 
	 * 7, 1: 1, 2, 5, 6
	 * 7, 2: 
	 * 7, 3: 1, 3, 4, 5
	 * */
	static boolean isConn(int cShape, int nShape, int dir) {
		switch (dir) {
			case 0:
				switch (cShape) {
					case 3:
					case 5:
					case 6:
						
						return false;
					default:
						switch (nShape) {
							case 3:
							case 4:
							case 7:
								
								return false;
							default:
								
								return true;
						}
				}
			case 1:
				switch (cShape) {
					case 3:
					case 4:
					case 7:
						
						return false;
					default:
						switch (nShape) {
							case 3:
							case 5:
							case 6:
								
								return false;
							default:
								
								return true;
						}
				}
			case 2:
				switch (cShape) {
				case 2:
				case 4:
				case 5:
					
					return false;
				default:
					switch (nShape) {
						case 2:
						case 6:
						case 7:
							
							return false;
						default:
							
							return true;
					}
				}
			default:
				switch (cShape) {
				case 2:
				case 6:
				case 7:
					
					return false;
				default:
					switch (nShape) {
						case 2:
						case 4:
						case 5:
							
							return false;
						default:
							
							return true;
					}
				}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		answer = 0;
		
		q = new LinkedList<>();
		q.offer(new int[] {R, C});
		
		time = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(time[i], Integer.MAX_VALUE);
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		time[R][C] = 1;
	}
}
