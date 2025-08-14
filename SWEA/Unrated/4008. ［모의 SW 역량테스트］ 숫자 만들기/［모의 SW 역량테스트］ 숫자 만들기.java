import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int min;
	static int max;
	static int answer;
	static int[] op;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			dfs(1, nums[0], op[0], op[1], op[2], op[3]);
			answer = max - min;
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int depth, int sum, int plus, int minus, int mul, int div) {
		if (depth == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			
			return;
		}
		
		if (plus > 0) dfs(depth + 1, sum + nums[depth], plus - 1, minus, mul, div);
		if (minus > 0) dfs(depth + 1, sum - nums[depth], plus, minus - 1, mul, div);
		if (mul > 0) dfs(depth + 1, sum * nums[depth], plus, minus, mul - 1, div);
		if (div > 0) dfs(depth + 1, sum / nums[depth], plus, minus, mul, div - 1);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		answer = 0;
		
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; ++i) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
}