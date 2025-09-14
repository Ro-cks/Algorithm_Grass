import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int[][] nums;
	
	static int answer;
	static int[] xDp; // i번째에 떼지 않았을 때의 최댓값
	static int[] uDp; // i번째에 위를 뗐을 때의 최댓값
	static int[] dDp; // i번째에 아래를 뗐을 때의 최댓값
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[2][N];
		
		answer = 0;
		xDp = new int[N];
		uDp = new int[N];
		dDp = new int[N];
		
		for (int i = 0; i < 2; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		xDp[0] = 0;
		uDp[0] = nums[0][0];
		dDp[0] = nums[1][0];
		
		for (int i = 1; i < N; ++i) {
			xDp[i] = Math.max(xDp[i - 1], Math.max(uDp[i - 1], dDp[i - 1]));
			uDp[i] = nums[0][i] + Math.max(xDp[i - 1], dDp[i - 1]);
			dDp[i] = nums[1][i] + Math.max(xDp[i - 1], uDp[i - 1]);
		}
		
		answer = Math.max(xDp[N - 1], Math.max(uDp[N - 1], dDp[N - 1]));
	}
}
