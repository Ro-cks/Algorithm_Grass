import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		for (int i = 0; i < N; ++i) {
			nums[i] = i + 1;
		}
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			reverse(start, end);
		}
		
		for (int i = 0; i < N; ++i) {
			sb.append(nums[i]).append(' ');
		}
		
		System.out.print(sb);
	}
	
	static void reverse(int start, int end) {
		int length = end - start + 1;
		
		int[] part = new int[length];
		for (int i = 0; i < length; ++i) {
			part[i] = nums[i + start - 1];
		}
		
		int j = 0;
		for (int i = end - 1; i >= start - 1; --i) {
			nums[i] = part[j++];
		}
	}
}
