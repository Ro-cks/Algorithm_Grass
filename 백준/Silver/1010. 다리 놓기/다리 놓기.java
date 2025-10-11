import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		dp = new long[31][31];
		for (int i = 0; i < 31; ++i) {
			dp[i][1] = i;
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		for (int i = 2; i < 31; ++i) {
			for (int j = 1; j < i; ++j) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		sb.append(dp[M][N]).append('\n');
	}
}
