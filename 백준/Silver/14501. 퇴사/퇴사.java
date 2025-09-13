import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int answer;
	static int[] T;
	static int[] P;
	static boolean[] sequence;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		T = new int[N];
		P = new int[N];
		answer = 0;
		sequence = new boolean[N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		DFS(0, 0);
		
		System.out.print(answer);
	}
	
	static void DFS(int day, int profit) {
		if (day >= N) {
			answer = Math.max(answer, profit);
			
			return;
		}
		
		DFS(day + 1, profit);
		
		if (day + T[day] <= N) {
			DFS(day + T[day], profit + P[day]);
		}
	}
}
