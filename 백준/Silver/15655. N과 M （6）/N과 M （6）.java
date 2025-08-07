import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] nums;
	static int[] sequence;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		sequence = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		dfs(0, 0);
		System.out.print(sb);
	}
	
	public static void dfs(int depth, int start) {
		if (depth == M) {
			for (int n : sequence) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			
			return;
		}
		for (int i = start; i < N; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				sequence[depth] = nums[i];
				dfs(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
