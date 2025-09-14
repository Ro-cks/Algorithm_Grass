import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static int[] sets;
	static int[] dp;
	static int[] values;
	static int[] groupSize;
	static int[] groupCandy;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		groupSize = new int[N + 1];
		groupCandy = new int[N + 1];
		
		sets = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			sets[i] = i;
		}
		
		dp = new int[K + 1];
		
		values = new int[N + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; ++i) {
			values[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() throws IOException {
		// union-find
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		// 그룹별 정보 저장
		for (int i = 1; i <= N; ++i) {
			int root = find(i);
			++groupSize[root];
			groupCandy[root] += values[i];
		}
		
		// knapsack
		for (int i = 1; i <= N; ++i) {
			if (groupSize[i] > 0) {
				int weight = groupSize[i];
				int value = groupCandy[i];
				
				for (int w = K - 1; w >= weight; --w) {
					dp[w] = Math.max(dp[w], dp[w - weight] + value);
				}
			}
		}
		
		System.out.print(dp[K - 1]);
	}
	
	static int find(int a) {
		if (sets[a] == a) {
			
			return a;
		}
		
		return sets[a] = find(sets[a]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) {
			
			return false;
		} else if (pa < pb) {
			sets[pb] = pa;
		} else {
			sets[pa] = pb;
		}
		
		return true;
	}
}
