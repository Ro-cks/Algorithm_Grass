import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int Q;
	static int L;
	static int R;
	static int[] nums;
	static int[] prefixSum;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		// 수열 A
		nums = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		prefixSum = new int[N + 1];
	}
	
	static void solution() throws IOException {
		Arrays.sort(nums);	// A였던 nums는 B가 됨
		
		for (int i = 0; i < N; ++i) {
			// prefixSum[1] = nums[0]
	        // prefixSum[2] = nums[0] + nums[1]
			// prefixSum[3] = nums[0] + nums[1] + ...
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}
		
		for (int i = 0; i < Q; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			// L = 1, R = 3 -> (nums[0]~nums[2])
	        // 0-based인 nums의 L-1 부터 R-1 까지의 합
	        // 1-based인 prefixSum의 R 에서 L-1 을 빼면 됨.
			int sum = prefixSum[R] - prefixSum[L - 1];
			
			sb.append(sum).append('\n');
		}
		
		System.out.print(sb);
	}
}
