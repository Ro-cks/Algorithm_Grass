import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int B;
	static int min;
	static int answer;
	static int[] heights;
	static int[] sequence;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution(0, 0);
			answer = min - B;
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	/* - 탑의 높이는 매번 체크, 중복X -> 부분 집합
	 * - height >= B && answer > height => answer = height
	 * */
	
	static void solution(int depth, int sum) {
		if (sum >= B) {
			min = Math.min(min, sum);
			
			return;
		}
		
		if (depth == N) return;
		
		solution(depth + 1, sum + heights[depth]);
		solution(depth + 1, sum);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		answer = 0;
		
		visited = new boolean[N];
		sequence = new int[N];
		heights = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
	}
}
