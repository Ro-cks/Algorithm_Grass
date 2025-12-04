import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] start;
	static int L = -1;
	static int R = -1;
	static int C = -1;
	static char[][][] map;
	
	static int[] dl = {0, 0, 0, 0, 1, -1};
	static int[] dr = {-1, 0, 1, 0, 0, 0};
	static int[] dc = {0, 1, 0, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		while (true) {
			init();
			
			if (L == 0) {
				
				break;
			}
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
				
		if (L == 0) {
			
			return;
		}
		
		map = new char[L][R][C];
		for (int i = 0; i < L; ++i) {
			for (int j = 0; j < R; ++j) {
				String input = br.readLine().trim();
				
				for (int k = 0; k < C; ++k) {
					char c = input.charAt(k);
					map[i][j][k] = c;
					
					if (c == 'S') {
						start = new int[] {i, j, k};
					}
				}
			}
			
			br.readLine();
		}
	}
	
	static void solution() {
		int answer = -1;
		
		int sl = start[0];
		int sr = start[1];
		int sc = start[2];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sl, sr, sc, 0});
		
		boolean[][][] visited = new boolean[L][R][C];
		visited[start[0]][start[1]][start[2]] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int l = curr[0];
			int r = curr[1];
			int c = curr[2];
			int time = curr[3];
			
			for (int d = 0; d < 6; ++d) {
				int nl = l + dl[d];
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				
				if (map[nl][nr][nc] == 'E') {
					answer = time + 1;
					
					sb.append("Escaped in ").append(answer).append(" minute(s).").append('\n');
					
					return;
				}
				
				if (visited[nl][nr][nc]) continue;
				if (map[nl][nr][nc] == '#') continue;
				
				visited[nl][nr][nc] = true;
				q.add(new int[] {nl, nr, nc, time + 1});
			}
		}
		
		sb.append("Trapped!").append('\n');
	}
}
