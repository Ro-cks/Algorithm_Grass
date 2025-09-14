import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static long[][] D;
	
	static final String CAN = "Enjoy other party";
	static final String CAN_T = "Stay here";
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = new long[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				D[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() throws IOException {
		for (int k = 0; k < N; ++k) {
			for (int s = 0; s < N; ++s) {
				for (int e = 0; e < N; ++e) {
					if (D[s][e] > D[s][k] + D[k][e]) {
						D[s][e] = D[s][k] + D[k][e];
					}
				}
			}
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if (D[u - 1][v - 1] <= cost) {
				sb.append(CAN);
			} else {
				sb.append(CAN_T);
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
