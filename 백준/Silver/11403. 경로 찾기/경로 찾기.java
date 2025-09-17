import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[][] D;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		D = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; ++j) {
				D[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		for (int k = 0; k < N; ++k) {
			for (int s = 0; s < N; ++s) {
				for (int e = 0; e < N; ++e) {
					if (D[s][k] == 1 && D[k][e] == 1) {
						D[s][e] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sb.append(D[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
