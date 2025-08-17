import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static final String HaruHaru = "HaruHaru";
	static final String Hing = "Hing";
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
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
			
			for (int d = 0; d < 2; ++d) {
				int nr;
				int nc;
				switch (d) {
					case 0:
						nr = cr + map[cr][cc];
						nc = cc;
						break;
					default:
						nr = cr;
						nc = cc + map[cr][cc];
				}
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					
					continue;
				}
				
				if (visited[nr][nc]) {
					
					continue;
				}
				
				if (map[nr][nc] >= N) {
					
					continue;
				}

				if (map[nr][nc] == -1) {
					sb.append(HaruHaru);
					
					return;
				}
				
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc});
			}
		}
		
		sb.append(Hing);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
