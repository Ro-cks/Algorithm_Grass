import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static long[][] dp;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() {
		dp[0][0] = 1;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) {
					continue;
				}
				
				int jump = map[i][j];
				
				int nextJ = jump + j;
				if (nextJ < N) {
					dp[i][nextJ] += dp[i][j];
				}
				
				int nextI = jump + i;
				if (nextI < N) {
					dp[nextI][j] += dp[i][j];
				}
			}
		}
		
		System.out.print(dp[N - 1][N - 1]);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		dp = new long[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
