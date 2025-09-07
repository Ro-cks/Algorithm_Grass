import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int S;
	static int answer;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() {
		int start = 0;
		int end = 0;
		long sum = 0;
		
		while (true) {
			if (sum >= S) {
				answer = Math.min(answer, end - start);
				sum -= nums[start++];
			} else if (end == N) {
				
				break;
			} else {
				sum += nums[end++];
			}
		}
		
		if (answer == N + 1) {
			System.out.print(0);
		} else {
			System.out.print(answer);
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		answer = N + 1;
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
}
