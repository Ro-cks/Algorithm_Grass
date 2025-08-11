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
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	
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
		dfs(0);
		
		set.forEach(System.out::println);
	}
	
	static void dfs(int depth) {
		if (depth == M) {
			sb = new StringBuilder();
			for (int n : sequence) {
				sb.append(n).append(' ');
			}
			
			set.add(sb.toString());
			
			return;
		}
		
		for (int i = 0; i < N; ++i) {			
			sequence[depth] = nums[i];
			dfs(depth + 1);
		}
	}
}
