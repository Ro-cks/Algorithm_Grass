import java.io.*;
import java.util.*;
/* (0, 0) -> (N - 1, N - 1)
 * 
 * */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int tc = 1;
	static int N;
	static int[][] D;
	static int[][] map;
	static boolean[][] visited;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		while (true) {
			init();
			
			if (N == 0) {
				
				break;
			}
			
			solution();
			
			sb.append("Problem ").append(tc++).append(": ").append(D[N - 1][N - 1]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	// map을 사방탐색 하면서 최단 거리 배열 업데이트 하기
	static void solution() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int cr = curr[0];
			int cc = curr[1];
			visited[cr][cc] = true;
			
			for (int[] dir : dirs) {
				int nr = cr + dir[0];
				int nc = cc + dir[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					
					continue;
				}
				
//				if (visited[nr][nc]) {
//					
//					continue;
//				}
				
				if (D[nr][nc] > D[cr][cc] + map[nr][nc]) {
					D[nr][nc] = D[cr][cc] + map[nr][nc];
					queue.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		if (N == 0) {
			
			return;
		}
		
		D = new int[N][N];
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; ++i) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		D[0][0] = map[0][0];
	}
}
