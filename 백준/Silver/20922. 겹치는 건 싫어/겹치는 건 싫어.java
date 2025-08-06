import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// --- init ---
		
		int left = 0;
		int right = 0;
		int maxLength = 0;
		int[] counts = new int[100001];
		
		while (right < N) {			
			if (counts[nums[right]] < K) {
				++counts[nums[right]];
				++right;
				maxLength = Math.max(maxLength, right - left);
			} else {
				--counts[nums[left]];
				++left;
			}
		}
		
		System.out.print(maxLength);
	}
}
