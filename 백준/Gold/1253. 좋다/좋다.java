import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static long[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new long[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Long.parseLong(st.nextToken());
		}
	}
	
	static void solution() {
		Arrays.sort(nums);
		int count = 0;
		
		for (int i = 0; i < N; ++i) {
			int left = 0;
			int right = N - 1;
			
			while (left < right) {
				if (nums[left] + nums[right] == nums[i]) {
					if (left != i && right != i) {
						++count;
						
						break;
					} else if (left == i) {
						++left;
					} else if (right == i) {
						--right;
					}
				} else if (nums[left] + nums[right] < nums[i]) {
					++left;
				} else {
					--right;
				}
			}
		}
		
		System.out.print(count);
	}
}
