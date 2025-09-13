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
		DFS(0);
		
		System.out.print(answer);
	}
	
	static void DFS(int depth) {
		if (depth == N) {
			cal();
			
			return;
		}
		
		sequence[depth] = true;
		DFS(depth + 1);
		sequence[depth] = false;
		DFS(depth + 1);
	}
	
	static void cal() {
		int day = 0;
		int profit = 0;
		
		for (int i = 0; i < N; ++i) {
			if (sequence[i]) {
				if (i + T[i] > N) continue;
				if (day + T[i] > N) continue;
				
				day += T[i];
				profit += P[i];
				i += T[i] - 1;
			}
		}
		
		answer = Math.max(answer, profit);
	}
}
