import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	static int T;
	static int N;
	static int K;
	static int top;
	static int answer;
	static int[][] map;
	static List<int[]> tops;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			for (int[] top : tops) {
				visited[top[0]][top[1]] = true;
				solution(top[0], top[1], 1, false);
				visited[top[0]][top[1]] = false;
			}
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution(int r, int c, int len, boolean cut) {
		answer = Math.max(answer, len);
		
		for (int[] dir : dirs) {
			int nr = r + dir[0];
			int nc = c + dir[1];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if (visited[nr][nc]) continue;
			
			if (map[r][c] > map[nr][nc]) {
				visited[nr][nc] = true;
				solution(nr, nc, len + 1, cut);
				visited[nr][nc] = false;
			} else if (!cut && map[r][c] > map[nr][nc] - K) {
				int original = map[nr][nc];
				map[nr][nc] = map[r][c] - 1;
				
				visited[nr][nc] = true;
				solution(nr, nc, len + 1, true);
				visited[nr][nc] = false;
				map[nr][nc] = original;
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		top = 0;
		answer = 0;
		tops = new ArrayList<>();
		visited = new boolean[N][N];
		
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; ++j) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				top = Math.max(top, map[i][j]);
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == top) {
					tops.add(new int[] {i, j});
				}
			}
		}
	}
}