import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] r; // i번째에 빨간색으로 집을 칠할 때 지금까지의 최소 비용
	static int[] g; 
	static int[] b;
	static int[][] dp;
	static int[][] costs;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		r = new int[N];
		g = new int[N];
		b = new int[N];
		dp = new int[N][3];
		
		costs = new int[N][3];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			costs[i][0] = r;
			costs[i][1] = g;
			costs[i][2] = b;
		}
	}
	
	static void solution() throws IOException {
		int answer = Integer.MAX_VALUE;
		
		dp[0][0] = costs[0][0];
		dp[0][1] = 1001 * 1000;
		dp[0][2] = 1001 * 1000;
		
		for (int i = 1; i < N; ++i) {
			dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
	        dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
	        dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		answer = Math.min(answer, Math.min(dp[N - 1][1], dp[N - 1][2]));
		
		dp[0][0] = 1001 * 1000;
	    dp[0][1] = costs[0][1];
	    dp[0][2] = 1001 * 1000;
	    
	    for (int i = 1; i < N; ++i) {
	        dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
	        dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
	        dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
	    }
	    
	    answer = Math.min(answer, Math.min(dp[N - 1][0], dp[N - 1][2]));
	    
	    dp[0][0] = 1001 * 1000;
	    dp[0][1] = 1001 * 1000;
	    dp[0][2] = costs[0][2];
	    
	    for (int i = 1; i < N; ++i) {
	        dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
	        dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
	        dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
	    }
	    
	    answer = Math.min(answer, Math.min(dp[N - 1][0], dp[N - 1][1]));

	    System.out.print(answer);
	}
}
