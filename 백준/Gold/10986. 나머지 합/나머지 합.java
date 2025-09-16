import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static long[] S;
	static long[] C;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = new long[N];
		C = new long[M];
		
		st = new StringTokenizer(br.readLine().trim());
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; ++i) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		long answer = 0;
		
		for (int i = 0; i < N; ++i) {
			int remainder = (int) (S[i] % M);
			if (remainder == 0) ++answer;
			++C[remainder];
		}
		
		for (int i = 0; i < M; ++i) {
			if (C[i] > 1) {
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		
		System.out.print(answer);
	}
}
