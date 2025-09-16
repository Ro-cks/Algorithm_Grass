import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N];
		
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(br.readLine().trim());
		}
	}
	
	static void solution() {
		Arrays.sort(nums);
		
		for (int i = 0; i < N; ++i) {
			sb.append(nums[i]).append('\n');
		}
		
		System.out.print(sb);
	}
}
