import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		dp = new int[N + 1][10];
	}
	
	static void solution() {
		long answer = 0;
		
		for (int i = 1; i < 10; ++i) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; ++i) {
			for (int j = 0; j <= 9; ++j) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % 1000000000;
					
					continue;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8] % 1000000000;
					
					continue;
				}
				dp[i][j] = (dp[i - 1][j - 1] % 1000000000 + dp[i - 1][j + 1] % 1000000000) % 1000000000;
			}
		}
		
		
		for (int j = 0; j < 10; ++j) {
			answer += dp[N][j] % 1000000000;
		}
		
		
		System.out.print(answer % 1000000000);
	}
}
