import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] D;
	
	static class Node {
		int num;
		int cost;
		
		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		D = new int[N + 1][N + 1];
		
		for (int i = 0; i <= N; ++i) {
			Arrays.fill(D[i], 3000);
			D[i][i] = 0;
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			D[u][v] = 1;
		}
	}
	
	static void solution() {
		for (int k = 1; k <= N; ++k) {
			for (int s = 1; s <= N; ++s) {
				for (int e = 1; e <= N; ++e) {
					if (D[s][e] > D[s][k] + D[k][e]) {
						D[s][e] = D[s][k] + D[k][e];
					}
				}
			}
		}
		
		for (int i = 1; i <= N; ++i) {
			int count = 0;
			
			for (int j = 1; j <= N; ++j) {
				if (D[i][j] == 3000 && D[j][i] == 3000) {
					++count;
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.print(sb);
	}
}
