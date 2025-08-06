import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;
		
		while (true) {
			if (sum >= M) {
				sum -= nums[left++];
			} else if (right == N) {
				break;
			} else {
				sum += nums[right++];
			}
			
			if (sum == M) {
				++count;
			}
		}
		
		System.out.print(count);
	}
}
