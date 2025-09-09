import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	static int[][] dp;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		System.out.print(solution(0, 0));
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(br.readLine().trim());
		dp = new int[n][n];
		nums = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			Arrays.fill(dp[i], -1);
			
			for (int j = 0; j < i + 1; ++j) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; ++i) {
			dp[n - 1][i] = nums[n - 1][i];
		}
	}
	
	static int solution(int depth, int idx) {
		if (depth == n - 1) {
			
			return dp[depth][idx];
		}
		
		if (dp[depth][idx] == -1) {
			dp[depth][idx] = Math.max(solution(depth + 1, idx), solution(depth + 1, idx + 1)) 
							 + nums[depth][idx];
		}
		
		return dp[depth][idx];
	}
}
