import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static boolean[][] conn;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			sb.append('#').append(tc).append(' ');
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		conn = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			conn[u][v] = true;
		}
	}
	
	static void solution() {
		for (int K = 1; K <= N; ++K) {
			for (int S = 1; S <= N; ++S) {
				for (int E = 1; E <= N; ++E) {
					if (conn[S][K] && conn[K][E]) {
						conn[S][E] = true;
					}
				}
			}
		}
		
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (conn[i][j] || conn[j][i]) {
					++arr[i];
				}
			}
		}
		
		int answer = 0;
		for (int num : arr) {
			if (num == N - 1) ++answer;
		}
		
		sb.append(answer).append('\n');
	}
}
