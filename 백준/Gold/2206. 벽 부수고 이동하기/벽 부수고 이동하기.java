import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[][] map;
	static int[][][] visited;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new int[N][M];
		visited = new int[N][M][2];
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static void solution() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0});
		visited[0][0][0] = 1;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int k = curr[2];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if (map[nr][nc] == 0) {
					if (visited[nr][nc][k] == 0) {
						visited[nr][nc][k] = visited[cr][cc][k] + 1;
						q.offer(new int[] {nr, nc, k});
					}
				} else {
					if (k == 0) {
						if (visited[nr][nc][1] == 0) {
							visited[nr][nc][1] = visited[cr][cc][0] + 1;
							q.offer(new int[] {nr, nc, 1});
						}
					}
				}
			}
		}
		
		if (visited[N - 1][M - 1][0] == 0 && visited[N - 1][M - 1][1] == 0) {
			answer = -1;
		} else if (visited[N - 1][M - 1][0] == 0) {
			answer = visited[N - 1][M - 1][1];
		} else if (visited[N - 1][M - 1][1] == 0) {
			answer = visited[N - 1][M - 1][0];
		} else {
			answer = Math.min(visited[N - 1][M - 1][0], visited[N - 1][M - 1][1]);
		}
		
		System.out.print(answer);
	}
}
