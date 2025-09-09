import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int[] W;
	static int[] V;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() {
		for (int i = 1; i <= N; ++i) {
			for (int j = K; j - W[i] >= 0; --j) {
				dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
			}
		}
		
		System.out.print(dp[K]);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N + 1];
		V = new int[N + 1];
		dp = new int[K + 1];
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
	}
}
