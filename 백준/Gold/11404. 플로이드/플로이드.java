import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int m;
	static int[][] D;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
	}
	
	static void solution() {
		for (int k = 0; k < n; ++k) {
			for (int s = 0; s < n; ++s) {
				for (int e = 0; e < n; ++e) {
					if (D[s][k] != Integer.MAX_VALUE && D[k][e] != Integer.MAX_VALUE) {
						if (D[s][e] > D[s][k] + D[k][e]) {
							D[s][e] = D[s][k] + D[k][e];
						}
					}
				}
			}
		}
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (D[i][j] == Integer.MAX_VALUE) {
					sb.append(0).append(' ');
				} else {
					sb.append(D[i][j]).append(' ');
				}
			}
			sb.append('\n');
		}
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(br.readLine().trim());
		m = Integer.parseInt(br.readLine().trim());
		
		D = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
			D[i][i] = 0;
		}
		
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			D[u][v] = Math.min(D[u][v], cost);
		}
	}
}
