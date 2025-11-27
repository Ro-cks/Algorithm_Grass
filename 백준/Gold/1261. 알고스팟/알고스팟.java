import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] D;
	static int[][] map;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Node implements Comparable<Node> {
		int num;
		int cost;
		
		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			
			return this.cost < n.cost ? -1 : 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		D = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			Arrays.fill(D[i], 1234567);
			String input = br.readLine().trim();
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static void solution() {
		int answer = 0;
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {0, 0});
		D[0][0] = 0;
		
		while (!dq.isEmpty()) {
			int[] curr = dq.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if (D[nr][nc] > D[cr][cc] + map[nr][nc]) {
					D[nr][nc] = D[cr][cc] + map[nr][nc];
					
					if (map[nr][nc] == 0) {
						dq.addFirst(new int[] {nr, nc});
					} else {
						dq.addLast(new int[] {nr, nc});
					}
				}
			}
		}
		
		System.out.print(D[N - 1][M - 1]);
	}
}
