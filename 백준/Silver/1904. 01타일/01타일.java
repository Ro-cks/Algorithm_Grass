import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] dp;
	
	static final int VALUE = 15746;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		dp = new int[1000001];
	}
	
	static void solution() {
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i = 4; i <= 1000000; ++i) {
			dp[i] = (dp[i - 1] % VALUE + dp[i - 2] % VALUE) % VALUE;
		}
		
		System.out.print(dp[N]);
	}
}
