import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int K;
	static int[] V;
	static int[] C;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			sb.append('#').append(tc).append(' ');
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		V = new int[N + 1]; // 부피
		C = new int[N + 1]; // 가치
		dp = new int[K + 1];
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			V[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		// 각 물건에 대해
		for (int i = 1; i <= N; ++i) {
			// j: 부피
			for (int j = K; j - V[i] >= 0; --j) {
				dp[j] = Math.max(dp[j], dp[j - V[i]] + C[i]);
			}
		}
		
		sb.append(dp[K]).append('\n');
	}
}
