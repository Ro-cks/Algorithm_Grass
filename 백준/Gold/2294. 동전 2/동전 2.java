import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int[] dp;
	static int[] coins;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[K + 1];
		coins = new int[N];
		
		for (int i = 0; i < N; ++i) {
			coins[i] = Integer.parseInt(br.readLine().trim());
		}
		
		Arrays.fill(dp, 10001);
		dp[0] = 0;
	}
	
	static void solution() {
		for (int i = 0; i < N; ++i) {
			for (int j = coins[i]; j <= K; ++j) {
				if (j - coins[i] >= 0) {
					dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
				}
			}
		}
		
		if (dp[K] == 10001) {
			System.out.print(-1);
		} else {
			System.out.print(dp[K]);
		}
	}
}
