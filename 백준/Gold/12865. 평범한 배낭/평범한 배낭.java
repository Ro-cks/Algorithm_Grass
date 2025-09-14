import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int[] weight;
	static int[] value;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N + 1];
		value = new int[N + 1];
		dp = new int[K + 1];
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for (int i = 1; i <= N; ++i) {
			for (int w = K; w >= weight[i]; --w) {
				dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
			}
		}
		
		System.out.print(dp[K]);
	}
}