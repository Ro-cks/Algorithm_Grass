import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[] nums;
	static boolean[] isPoped;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N];
		isPoped = new boolean[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		isPoped[0] = true;
		int dist = nums[0];
		int pointer = 0;
		sb.append(1).append(' ');
		
		for (int i = 0; i < N - 1; ++i) {
			int dir = (dist > 0) ? 1 : -1;
			int count = Math.abs(dist);
			
			while (count > 0) {
				pointer = (((pointer + dir) % N) + N) % N;
				
				if (!isPoped[pointer]) {
					--count;
				}
			}
			
			sb.append(pointer + 1).append(' ');
			isPoped[pointer] = true;
			
			dist = nums[pointer];
		}
		
		System.out.print(sb);
	}
}
