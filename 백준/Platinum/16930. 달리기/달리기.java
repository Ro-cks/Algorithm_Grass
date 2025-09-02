import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static int answer;
	static int[] end;
	static int[][] time;
	static char[][] map;
	static Queue<int[]> q;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.print(answer);
	}
	
	static void solution() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			if(map[cr][cc]=='*') {
				answer = time[cr][cc];
				return;
			}
			
			for (int d = 0; d < 4; ++d) {
				for (int i = 1; i <= K; ++i) {
					int nr = cr + dr[d] * i;
					int nc = cc + dc[d] * i;
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
					if (map[nr][nc] == '#') break;
					
//					if (map[nr][nc] == '*') {
//						answer = time[cr][cc]+1;
//						
//						return;
//					}
					
					
					if (time[nr][nc] == time[cr][cc] + 1) continue;
					if (time[nr][nc] < time[cr][cc] + 1) break; 
					
					
					time[nr][nc] = time[cr][cc] + 1;
					
					
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		
		time = new int[N][M];
		
		q = new LinkedList<>();
		
		map = new char[N][M];
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			Arrays.fill(time[i], Integer.MAX_VALUE);
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine().trim());
		int row1 = Integer.parseInt(st.nextToken()) - 1;
		int col1 = Integer.parseInt(st.nextToken()) - 1;
		q.offer(new int[] {row1, col1});
		time[row1][col1] = 0;
		
		int row2 = Integer.parseInt(st.nextToken()) - 1;
		int col2 = Integer.parseInt(st.nextToken()) - 1;
		map[row2][col2] = '*';
	}
}
