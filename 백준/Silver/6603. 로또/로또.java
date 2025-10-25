import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int k;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine().trim());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				
				break;
			}
			
			nums = new int[k];
			for (int i = 0; i < k; ++i) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			solution();
			sb.append('\n');
		}
		
		sb.setLength(sb.length() - 2);
	}
	
	static void solution() {
		DFS(0, 0, new StringBuilder());
	}
	
	static void DFS(int depth, int start, StringBuilder tmp) {
		if (depth == 6) {
			sb.append(tmp.toString().trim()).append('\n');
			
			return;
		}
		
		for (int i = start; i < k; ++i) {
			int length = tmp.length();
			
			tmp.append(nums[i]).append(' ');
			DFS(depth + 1, i + 1, tmp);
			tmp.setLength(length);
		}
	}
}
