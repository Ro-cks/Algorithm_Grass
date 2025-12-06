import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int l;
	static int sr;
	static int sc;
	static int tr;
	static int tc;
	
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; ++t) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		l = Integer.parseInt(br.readLine().trim());
		
		st = new StringTokenizer(br.readLine().trim());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		tr = Integer.parseInt(st.nextToken());
		tc = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		int answer = bfs(sr, sc);
		
		sb.append(answer).append('\n');
	}
	
	static int bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c, 0});
		boolean[][] visited = new boolean[l][l];
		visited[r][c] = true;
		
		int answer = 0;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int len = curr[2];
			
			for (int d = 0; d < 8; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= l || nc < 0 || nc >= l) continue;
				if (visited[nr][nc]) continue;
				
				if (nr == tr && nc == tc) {
					
					return len + 1;
				}
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, len + 1});
			}
		}
		
		return answer;
	}
}
