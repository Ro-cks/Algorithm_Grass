import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] A;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		A = new int[N];
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for (int i = 0; i < N; ++i) {
			dp[i] = A[i];
			
			for (int j = 0; j < i; ++j) {
				if (A[i] > A[j] && dp[i] < dp[j] + A[i]) {
					dp[i] = dp[j] + A[i];
				}
			}
		}
		
		Arrays.sort(dp);
		
		System.out.print(dp[N - 1]);
	}
}
