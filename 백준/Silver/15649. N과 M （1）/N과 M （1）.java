import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/15649
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
		
		dfs(0);
		
		System.out.print(sb);
	}
	
	public static void dfs(int depth) {
		if (depth == M) {
			for (int num : sequence) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			
			return;
		}
		
		for (int i = 1; i <= N; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				sequence[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
				sequence[depth] = 0;
			}
		}
	}
}
