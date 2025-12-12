import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; ++t) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() {
		dp = new int[11];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= 10; ++i) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
	}
	
	static void solution() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		sb.append(dp[N]).append('\n');
	}
}
