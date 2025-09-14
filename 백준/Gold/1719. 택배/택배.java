import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] D;
	static int[][] answer;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new int[N][N];
		answer = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			Arrays.fill(D[i], 100000000);
			D[i][i] = 0;
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			D[u][v] = cost;
			D[v][u] = cost;
			
			answer[u][v] = v + 1;
			answer[v][u] = u + 1;
		}
	}
	
	static void solution() {
		floyd();
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i == j) {
					sb.append('-');
				} else {
					sb.append(answer[i][j]);
				}
				sb.append(' ');
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void floyd() {
		for (int k = 0; k < N; ++k) {
			for (int s = 0; s < N; ++s) {
				for (int e = 0; e < N; ++e) {
					if (D[s][e] > D[s][k] + D[k][e]) {
						D[s][e] = D[s][k] + D[k][e];
						answer[s][e] = answer[s][k];
					}
				}
			}
		}
	}
}
