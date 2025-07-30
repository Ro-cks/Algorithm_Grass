import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/1012
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static int M;
	public static int N;
	public static int[][] grid;
	public static boolean[][] isVisited;
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		while (--T >= 0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			grid = new int[N][M];
			isVisited = new boolean[N][M];
			
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				grid[y][x] = 1;
			}
			
			int count = 0;
			for (int y = 0; y < N; ++y) {
				for (int x = 0; x < M; ++x) {
					if (grid[y][x] == 1 && !isVisited[y][x]) {
						dfs(y, x);
						++count;
					}
				}
			}
			
			System.out.println(count);
		}
		
		
	}
	
	public static void dfs(int y, int x) {
		isVisited[y][x] = true;
		
		for (int d = 0; d < 4; ++d) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
				continue;
			}
			
			if (grid[ny][nx] == 1 && !isVisited[ny][nx]) {
				dfs(ny, nx);
			}
		}
	}
}
