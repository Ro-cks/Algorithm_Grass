import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int answer;
	static int[][] D;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		D = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				int val = Integer.parseInt(st.nextToken());
				
				if (val == 0 && i != j) {
					D[i][j] = Integer.MAX_VALUE;
				} else {
					D[i][j] = val;
				}
			}
		}
	}
	
	/* 0 1 1 0 0 
	 * 1 0 1 1 1 
	 * 1 1 0 0 0 
	 * 0 1 0 0 0 
	 * 0 1 0 0 0
	 * */
	static void solution() {
		for (int k = 0; k < N; ++k) {
			for (int s = 0; s < N; ++s) {
				for (int e = 0; e < N; ++e) {
					if (D[s][k] != Integer.MAX_VALUE && D[k][e] != Integer.MAX_VALUE) {
						D[s][e] = Math.min(D[s][e], D[s][k] + D[k][e]);
					}
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			
			int cc = 0;
			for (int j = 0; j < N; ++j) {
				cc += D[i][j];
			}
			
			answer = Math.min(answer, cc);
		}
	}
}
