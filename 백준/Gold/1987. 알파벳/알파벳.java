import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R;
	static int C;
	static int answer;
	static char[][] board;
	static boolean[] visited = new boolean[26];
	
	static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		visited[board[0][0] - 'A'] = true;
		DFS(0, 0, 1);
	}
	
	static void DFS(int r, int c, int count) {
		answer = Math.max(answer, count);
		
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
				
				continue;
			}
			
			if (visited[board[nr][nc] - 'A']) {
				
				continue;
			}

			visited[board[nr][nc] - 'A'] = true;
			DFS(nr, nc, count + 1);
			visited[board[nr][nc] - 'A'] = false;
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = Integer.MIN_VALUE;
		
		board = new char[R][C];
		for (int r = 0; r < R; ++r) {
			String input = br.readLine();
			
			for (int c = 0; c < C; ++c) {
				board[r][c] = input.charAt(c);
			}
		}
	}
}
