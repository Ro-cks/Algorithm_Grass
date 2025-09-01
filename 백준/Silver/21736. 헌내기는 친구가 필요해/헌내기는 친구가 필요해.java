import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 'X') continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] == 'P') {
					++answer;
				}
				
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
		if (answer == 0) {
			System.out.print("TT");
			System.exit(0);
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		visited = new boolean[N][M];
		q = new LinkedList<>();
		
		map = new char[N][M];
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < M; ++j) {
				char val = input.charAt(j);
				map[i][j] = val;
				
				if (val == 'I') {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
	}
}
