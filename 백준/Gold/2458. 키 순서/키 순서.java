import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[] counts;
	static boolean[][] conn;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		for (int k = 1; k <= N; ++k) {
			for (int s = 1; s <= N; ++s) {
				for (int e = 1; e <= N; ++e) {
					if (conn[s][k] && conn[k][e]) {
						conn[s][e] = true;
					}
				}
			}
		}
		
		for (int s = 1; s <= N; ++s) {
			for (int e = 1; e <= N; ++e) {
				if (conn[s][e] || conn[e][s]) {
					++counts[s];
				}
			}
		}
		
		for (int i = 1; i <= N; ++i) {
			if (counts[i] == N -1) {
				++answer;
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		counts = new int[N + 1];
		conn = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			conn[from][to] = true;
		}
	}
}
