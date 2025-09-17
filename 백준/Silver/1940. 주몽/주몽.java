import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		Arrays.sort(nums);
		int count = 0;
		int left = 0;
		int right = N - 1;
		
		while (left < right) {
			if (nums[left] + nums[right] < M) {
				++left;
			} else if (nums[left] + nums[right] > M) {
				--right;
			} else {
				++count;
				++left;
				--right;
			}
		}
		
		System.out.print(count);
	}
}
