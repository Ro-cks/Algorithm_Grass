import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int answer;
	static int[][] dp;
	static int[][] costs;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() {
		dp[1][0] = costs[0][0];
		dp[1][1] = costs[0][1];
		dp[1][2] = costs[0][2];
		
		for (int i = 2; i <= N; ++i) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i - 1][2];
		}
		
		answer = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
		
		System.out.print(answer);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		costs = new int[N][3];
		dp = new int[N + 1][3];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < 3; ++j) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
