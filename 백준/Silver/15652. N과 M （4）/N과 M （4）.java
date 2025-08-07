import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] sequence;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sequence = new int[M];
		visited = new boolean[N + 1];
		
		dfs(0, 1);
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
		
		for (int i = start; i <= N; ++i) {
			sequence[depth] = i;
			dfs(depth + 1, i);
		}
	}
}
