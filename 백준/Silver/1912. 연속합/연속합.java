import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		int answer = 0;
		int[] dp = new int[N];
		dp[0] = nums[0];
		answer = dp[0];
		
		for (int i = 1; i < N; ++i) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.print(answer);
	}
}
