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
		
		dp = new int[N + 2][N + 2];
	}
	
	static void solution() {
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		
		for (int i = 3; i <= N + 1; ++i) {
			for (int j = 1; j <= i; ++j) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		System.out.print(dp[N][K]);
	}
}
