import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] nums;
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N + 1];
		dp = new boolean[N + 1][N + 1];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine().trim());
	}
	
	static void solution() throws IOException {
		for (int i = 1; i <= N; ++i) {
			dp[i][i] = true;
		}
		
		for (int i = 1; i <= N - 1; ++i) {
			dp[i][i + 1] = nums[i] == nums[i + 1];
		}
		
		for(int i = 2; i < N; ++i){
            for(int j = 1; j <= N - i; ++j){
                if(nums[j] == nums[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if (dp[S][E]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
