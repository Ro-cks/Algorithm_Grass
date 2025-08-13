import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int number;
	static int length;
	static int[][] grid;
	static boolean[][] visited;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					visited[i][j] = true;
					dfs(i, j, 1, grid[i][j]);
					visited[i][j] = false;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(number).append(' ').append(length).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int x, int y, int len, int startNumber) {
		if (len > length) {
			length = len;
			number = startNumber;
		} else if (len == length) {
			number = Math.min(number, startNumber);
		}
		
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visited[nx][ny]) continue;
			
			if (grid[nx][ny] == grid[x][y] + 1) {
				visited[nx][ny] = true;
				dfs(nx, ny, len + 1, startNumber);
				visited[nx][ny] = false;
			}
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		length = 0;
		visited = new boolean[N][N];
		
		grid = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
