import java.io.*;
import java.util.*;

/* 1. 일꾼 배치
 * 2. 수익 계산
 * 3. 최대 수익 산정
 * 
 * 1. 일꾼 배치: 
 *     조합으로 시작 위치 정하기
 * 2. 수익 계산:
 *     적절한 로직으로 수익 계산
 * 3. 최대 수익 산정:
 *     계산된 수익과 기존의 최댓값 비교
 * */

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static int C;
	static int answer;
	static int[][] sequence;
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
		C = Integer.parseInt(st.nextToken());
		answer = 0;
		sequence = new int[2][2];
		map = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		combo(0, 0);
	}
	
	// 1. 일꾼 배치
	static void combo(int depth, int start) {
		if (depth == 2) {
			int[] first = sequence[0];
			int[] second = sequence[1];
			
			int firstProfit = getMaxProfit(first[0], first[1], 0, 0, 0);
			int secondProfit = getMaxProfit(second[0], second[1], 0, 0, 0);
			
			answer = Math.max(answer, firstProfit + secondProfit);
			
			return;
		}
		
		for (int i = start; i < N * N; ++i) {
			int r = i / N;
			int c = i % N;
			if (c > N - M) continue;
			
			sequence[depth][0] = r;
			sequence[depth][1] = c;
			
			combo(depth + 1, i + M);
		}
	}
	
	static int getMaxProfit(int r, int c, int idx, int sum, int profit) {
		if (sum > C) {
			
			return 0;
		}
		
		if (idx == M) {
			
			return profit;
		}
		
		int curr = map[r][c + idx];
		int a = getMaxProfit(r, c, idx + 1, sum + curr, profit + curr * curr);
		int b = getMaxProfit(r, c, idx + 1, sum, profit);
		
		return Math.max(a, b);
	}
}
