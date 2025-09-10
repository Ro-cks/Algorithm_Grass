import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int answer;
	static int[] costs;
	static int[] plans;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			DFS(0, 0);
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		costs = new int[4];
		plans = new int[12];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 4; ++i) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 12; ++i) {
			plans[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1년 이용권으로 초기화
		answer = costs[3];
	}
	
	static void DFS(int month, int sum) {
		// 기존의 answer(최솟값)보다 커지면
		if (sum >= answer) {
			
			return;
		}
		
		// 12월까지 모두 했다면
		if (month > 11) {
			answer = Math.min(answer, sum);
			
			return;
		}
		
		// 이번 달에 이용 계획이 없다면
		if (plans[month] == 0) {
			DFS(month + 1, sum);
		} else {
			// 일일 이용권
			DFS(month + 1, sum + costs[0] * plans[month]);
			
			// 한 달 이용권
			DFS(month + 1, sum + costs[1]);
			
			// 세 달 이용권
			DFS(month + 3, sum + costs[2]);
		}
	}
}
