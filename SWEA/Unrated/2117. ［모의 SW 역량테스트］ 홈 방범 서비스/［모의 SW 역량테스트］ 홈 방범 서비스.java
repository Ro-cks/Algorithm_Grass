import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static int answer;
	static int[][] map;
	
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
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		for (int k = 1; k < N + 2; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					project(k, i, j);
				}
			}
		}
	}
	
	static void project(int k, int i, int j) {
		int sr = i - k + 1;
		int sc = j - k + 1;
		int profit = 0;
		int count = 0;
		int area = k * k + (k - 1) * (k - 1);
		
		for (int r = sr; r <= i + k - 1; ++r) {
			for (int c = sc; c <= j + k - 1; ++c) {
				if (r < 0 || r >= N || c < 0 || c >= N) continue;
				
				if (Math.abs(r - i) + Math.abs(c - j) <= (k - 1)) {
					if (map[r][c] == 1) {
						profit += M;
						++count;
					}
				}
			}
		}
		
		if (profit - area >= 0) {
			answer = Math.max(answer, count);
		}
	}
}
