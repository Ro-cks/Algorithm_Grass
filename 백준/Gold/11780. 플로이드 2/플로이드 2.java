import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] D;
	static int[][] next;
	
	static final int INF = 10000001;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		D = new int[N][N];
		for (int i = 0; i < N; ++i) {
			Arrays.fill(D[i], INF);
			
			D[i][i] = 0;
		}
		
		next = new int[N][N];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			if (D[u][v] > cost) {
				D[u][v] = cost;
				next[u][v] = v;
			}
			
		}
	}
	
	static void solution() {
		for (int k = 0; k < N; ++k) {
			for (int s = 0; s < N; ++s) {
				for (int e = 0; e < N; ++e) {
					if (D[s][e] > D[s][k] + D[k][e]) {
						D[s][e] = D[s][k] + D[k][e];
						next[s][e] = next[s][k];
					}
				}
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (D[i][j] == INF) {
					sb.append(0);
				} else {
					sb.append(D[i][j]);
				}
				sb.append(' ');
			}
			sb.append('\n');
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i == j || D[i][j] >= INF) {
					sb.append(0).append('\n');
					
					continue;
				}
				
				List<Integer> path = new ArrayList<>();
				int curr = i;
				while (curr != j) {
					path.add(curr);
					curr = next[curr][j];
				}
				path.add(j);
				
				sb.append(path.size()).append(' ');
				
				for (int n : path) {
					sb.append(n + 1).append(' ');
				}
				sb.append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
