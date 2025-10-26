import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int min;
	static int max;
	static int[] nums;
	static int[] ops;
	static int[] sequence;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N];
		ops = new int[4];
		sequence = new int[N - 1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0 ; i < 4; ++i) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		DFS(1, nums[0], ops[0], ops[1], ops[2], ops[3]);
		
		System.out.println(max);
		System.out.print(min);
	}
	
	static void DFS(int depth, int sum, int plus, int minus, int multiply, int divide) {
		if (depth == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			
			return;
		}
		
		if (plus > 0) {
			DFS(depth + 1, sum + nums[depth], plus - 1, minus, multiply, divide);
		}
		
		if (minus > 0) {
			DFS(depth + 1, sum - nums[depth], plus, minus - 1, multiply, divide);
		}
		
		if (multiply > 0) {
			DFS(depth + 1, sum * nums[depth], plus, minus, multiply - 1, divide);
		}
		
		if (divide > 0) {
			DFS(depth + 1, sum / nums[depth], plus, minus, multiply, divide - 1);
		}
	}
}
