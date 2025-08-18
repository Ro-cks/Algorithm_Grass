import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int answer;
	static int[] weights;
	static int[] sequence;
	static boolean[] visited;
	
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
		perm(0);
	}
	
	static void perm(int depth) {
		if (depth == N) {
			subs(0, 0, 0);
			
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			if (visited[i]) continue;
			
			visited[i] = true;
			sequence[depth] = weights[i];
			perm(depth + 1);
			visited[i] = false;
		}
	}
	
	static void subs(int depth, int left, int right) {
		if (left < right) return;
		
		if (depth == N) {
			++answer;
			
			return;
		}
		
		subs(depth + 1, left + sequence[depth], right);
		subs(depth + 1, left, right + sequence[depth]);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		weights = new int[N];
		sequence = new int[N];
		visited = new boolean[N];
		answer = 0;
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
	}
}