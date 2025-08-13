import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int sumA;
	static int sumB;
	static int answer;
	static int[][] S;
	static boolean[] foods;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			init();
			
			dfs(0, 0);
			
			sb.append('#').append(t).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int depth, int start) {
		if (depth == N / 2) {
			sumA = 0;
			sumB = 0;
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (foods[i] && foods[j] && i != j) {
						sumA += S[i][j];
					} else if (!foods[i] && !foods[j] && i != j) {
						sumB += S[i][j];
					}
				}
			}
			
			answer = Math.min(answer, Math.abs(sumA - sumB));
			
			return;
		}
		
		for (int i = start; i < N; ++i) {
			if (foods[i]) {
				
				continue;
			}
			
			foods[i] = true;
			dfs(depth + 1, i + 1);
			foods[i] = false;
		}
	}
	
	static void init() throws IOException{
		N = Integer.parseInt(br.readLine());
		
		answer = Integer.MAX_VALUE;
		S = new int[N][N];
		foods = new boolean[N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; ++j) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
