import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int answer;
	static int[] xs;
	static int[] ys;
	static int[][] sequence;
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
		sequence[0][0] = xs[0];
		sequence[0][1] = ys[0];
		sequence[N + 1][0] = xs[1];
		sequence[N + 1][1] = ys[1];
		
		perm(1);
	}
	
	static void perm(int depth) {
		if (depth == N + 1) {
			calMinCost();
			
			return;
		}
		
		for (int i = 2; i <= N + 1; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				sequence[depth][0] = xs[i];
				sequence[depth][1] = ys[i];
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	static void calMinCost() {
		int tmp = 0;
		
		for (int i = 0; i < N + 1; ++i) {
			int x1 = sequence[i][0];
			int y1 = sequence[i][1];
			int x2 = sequence[i + 1][0];
			int y2 = sequence[i + 1][1];
			
			tmp += Math.abs(x1 - x2) + Math.abs(y1 - y2);
		}
		
		answer = Math.min(answer, tmp);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		answer = Integer.MAX_VALUE;
		xs = new int[N + 2];
		ys = new int[N + 2];
		sequence = new int[N + 2][2];
		visited = new boolean[N + 2];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N + 2; ++i) {
			xs[i] = Integer.parseInt(st.nextToken());
			ys[i] = Integer.parseInt(st.nextToken());
		}
	}
}
