import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int[] dp;
	static int[] xDp;
	static int[] uDp;
	static int[] dDp;
	
	static final int VALUE = 9901;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		dp = new int[N + 1];
		xDp = new int[N + 1];
		uDp = new int[N + 1];
		dDp = new int[N + 1];
	}
	
	static void solution() {
		xDp[1] = 1;
		uDp[1] = 1;
		dDp[1] = 1;
		dp[1] = 3;
		
		for (int i = 2; i <= N; ++i) {
			xDp[i] = (xDp[i - 1] % VALUE + uDp[i - 1] % VALUE + dDp[i - 1] % VALUE) % VALUE;
			uDp[i] = (xDp[i - 1] % VALUE + dDp[i - 1] % VALUE) % VALUE;
			dDp[i] = (xDp[i - 1] % VALUE + uDp[i - 1] % VALUE) % VALUE;
			dp[i] = (xDp[i] % VALUE + uDp[i] % VALUE + dDp[i] % VALUE) % VALUE;
		}
		
		System.out.print(dp[N]);
	}
}
