import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int L;
	static int answer; // score
	
	static int[][] foods;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; ++t) {
			init();
			
			dfs(0);
			
			sb.append('#').append(t).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int cnt) {
		if (cnt == N) {
			int sum = 0; // score
			int cal = 0;
			
			for (int i = 0; i < N; ++i) {
				if (selected[i]) {
					sum += foods[i][0];
					cal += foods[i][1];
					
					if (cal > L) {
						
						return;
					}
				}
			}
			
			answer = Math.max(answer, sum);
			
			return;
		}
		
		selected[cnt] = true;
		dfs(cnt + 1);
		selected[cnt] = false;
		dfs(cnt + 1);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		answer = Integer.MIN_VALUE;
		foods = new int[N][2];
		selected = new boolean[N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 2; ++j) {
				foods[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
