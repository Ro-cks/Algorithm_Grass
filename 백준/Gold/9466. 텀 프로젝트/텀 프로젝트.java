import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int teamCount;
	static int[] sets;
	static int[] status;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			init();
			
			solution();
			
			sb.append(N - teamCount).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		teamCount = 0;
		sets = new int[N + 1];
		status = new int[N + 1];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; ++i) {
			sets[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for (int i = 1; i <= N; ++i) {
			if (status[i] == 0) {
				DFS(i);
			}
		}
	}
	
	static void DFS(int u) {		
		status[u] = 1;
		
		int v = sets[u];
		
		if (status[v] == 0) {
			DFS(v);
		} else if (status[v] == 1) {
			++teamCount;
			int curr = v;
			
			while (sets[curr] != v) {
				++teamCount;
				curr = sets[curr];
			}
		}
		
		status[u] = 2;
	}
}
