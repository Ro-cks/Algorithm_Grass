import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int[] coins;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		dp = new int[K + 1];
		
		for (int i = 0; i < N; ++i) {
			coins[i] = Integer.parseInt(br.readLine().trim());
		}
	}
	
	static void solution() {
		dp[0] = 1;
		
		for (int i = 0; i < N; ++i) {
			int c = coins[i];
			
			for (int j = c; j <= K; ++j) {
				dp[j] = dp[j] + dp[j - c];
			}
		}
		
		System.out.print(dp[K]);
	}
}
