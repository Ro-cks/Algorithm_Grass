import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][N + 1];
	}
	
	static void solution() {
		for (int i = 0; i <= N; ++i) {
			dp[i][0] = 1;
			dp[i][1] = i;
			dp[i][i] = 1;
		}
		
		for (int i = 2; i <= N; ++i) {
			for (int j = 1; j < i; ++j) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				dp[i][j] = dp[i][j] % 10007;
			}
		}
		
		System.out.print(dp[N][K]);
	}
}
