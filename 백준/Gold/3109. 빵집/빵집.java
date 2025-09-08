import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R;
	static int C;
	static int answer;
	static char[][] map;
	
	static int[] dr = {-1, 0, 1};
	static int[] dc = { 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new char[R][C];
		
		for (int i = 0; i < R; ++i) {
			map[i] = br.readLine().toCharArray();
		}
	}
	
	static void solution() {
		for (int i = 0; i < R; ++i) {
			if (DFS(i, 0)) {
				++answer;
			}
		}
		
		System.out.print(answer);
	}
	
	static boolean DFS(int r, int c) {
		map[r][c] = 'x';
		
		if (c == C - 1) {
			
			return true;
		}
		
		for (int d = 0; d < 3; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if (map[nr][nc] == 'x') continue;
			
			if (DFS(nr, nc)) {
				
				return true;
			}
		}
		
		return false;
	}
}
