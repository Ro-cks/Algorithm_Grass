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
		
		for (int i = 0; i < 3; ++i) {
			dp[0][i] = costs[0][i];
			dp[0][(i + 1) % 3] = 1001 * 1000;
			dp[0][(i + 2) % 3] = 1001 * 1000;
			
			for (int j = 1; j < N; ++j) {
				dp[j][0] = costs[j][0] + Math.min(dp[j - 1][1], dp[j - 1][2]);
		        dp[j][1] = costs[j][1] + Math.min(dp[j - 1][0], dp[j - 1][2]);
		        dp[j][2] = costs[j][2] + Math.min(dp[j - 1][0], dp[j - 1][1]);
			}
			
			answer = Math.min(answer, Math.min(dp[N - 1][(i + 1) % 3], dp[N - 1][(i + 2) % 3]));
		}

	    System.out.print(answer);
	}
}
