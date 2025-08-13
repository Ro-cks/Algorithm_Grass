import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int K;
	static int top = 0;
	static int answer;
	static int[][] map;
	static boolean[][] visited;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] == top) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	/* bfs(): 사방탐색, 높이가 낮은 곳으로만 이동 가능
	 * 시작 위치를 제외한 모든 곳을 한 번씩 -K 한 이후 탐색
	 * 탐색이 끝나면 원복
	 * */
	static void dfs(int x, int y, int len, boolean cutUsed) {
		answer = Math.max(answer, len);
		
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visited[nx][ny]) continue;
			
			if (map[nx][ny] < map[x][y]) {
				visited[nx][ny] = true;
				dfs(nx, ny, len + 1, cutUsed);
				visited[nx][ny] = false;
			} else if (!cutUsed && map[nx][ny] - K < map[x][y]) {
				int original = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;
				
				visited[nx][ny] = true;
				dfs(nx, ny, len + 1, true);
				visited[nx][ny] = false;
				map[nx][ny] = original;
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MIN_VALUE;
		top = 0;
		
		visited = new boolean[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				top = Math.max(top, map[i][j]);
			}
		}
	}
}
