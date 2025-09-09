import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int answer;
	static int[] dp;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() {
		for (int i = 0; i < N; ++i) {
			dp[i] = 1;
			
			for (int j = 0; j < i; ++j) {
				if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = -1;
		for (int i = 0; i < N; ++i) {
			max = dp[i] > max ? dp[i] : max;
		}
		
		System.out.print(max);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		dp = new int[N];
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
}
