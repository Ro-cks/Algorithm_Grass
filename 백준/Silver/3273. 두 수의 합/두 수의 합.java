import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		int answer = count(nums, x, n);
		
		System.out.println(answer);
	}
	
	public static int count(int[] nums, int x, int n) {
		int answer = 0;
		int left = 0;
		int right = n - 1;
		
		Arrays.sort(nums);
		
		while (left < right) {
			int sum = nums[left] + nums[right];
			
			if (sum == x) {
				++answer;
			}
			
			if (sum < x) {
				++left;
			} else {
				--right;
			}
		}
		
		return answer;
	}
}
