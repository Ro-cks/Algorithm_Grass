import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][] nums;
	static int[][] S;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N][N];
		S = new int[N + 1][N + 1];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + nums[i - 1][j - 1];
			}
		}
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			int answer = S[r2][c2] - S[r2][c1 -1] - S[r1 - 1][c2] + S[r1 - 1][c1 - 1];
			sb.append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
}
