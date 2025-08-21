import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static String answer;
	static int[][] map;
	static boolean[][] visited;
	
	static int[][] dirs = { {1, 0}, {0, 1} };
	
	static final String yes = "Yes";
	static final String no = "No";
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		BFS();
	}
	
	static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int cr = curr[0];
			int cc = curr[1];
			
			if (cr == M - 1 && cc == N - 1) {
				answer = yes;
				
				return;
			}
			
			for (int[] dir : dirs) {
				int nr = cr + dir[0];
				int nc = cc + dir[1];
				
				if (nr < 0 || nr >= M || nc < 0 || nc >= N) {
					
					continue;
				}
				
				if (visited[nr][nc]) {
					
					continue;
				}
				
				if (map[nr][nc] == 0) {
					
					continue;
				}
				
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc});
			}
		}
		
		answer = no;
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int m = 0; m < M; ++m) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int n = 0; n < N; ++n) {
				map[m][n] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
