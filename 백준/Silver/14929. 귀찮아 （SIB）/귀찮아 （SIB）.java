import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/14929/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[n];
		int[] prefixSum = new int[n + 1];
		
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
			
			prefixSum[i + 1] = nums[i] + prefixSum[i];
		}
		
		long answer = 0;
		for (int i = 0; i < n; ++i) {
			int standard = nums[i];
			int prefix = prefixSum[n] - prefixSum[i + 1];
			
			answer += standard * prefix;
		}
		
		System.out.print(answer);
	}
}
