import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N;
	static int answer;
	static boolean[] nums;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		int k = 0;
		boolean isNotOver = true;
		
		while (isNotOver) {
			int num = N * ++k;
			int tmp = num;
			
			while (tmp > 0) {
				nums[tmp % 10] = true;
				tmp /= 10;
			}
			
			int count = 0;
			for (int i = 0; i < 10; ++i) {
				if (nums[i] == true) ++count; 
			}
			
			if (count == 10) isNotOver = false;
		}
		
		answer = N * k;
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new boolean[10];
		answer = 0;
	}
}
