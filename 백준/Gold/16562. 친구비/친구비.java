import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int k;
	static int answer;
	static int[] sets;
	static int[] costs;
	static Set<Integer> hashSet;
	
	private static class Friend {
		int num;
		int cost;
		
		public Friend(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		for (int i = 1; i <= N; ++i) {
			hashSet.add(find(i));
		}
		
		for (int set : hashSet) {
			answer += costs[set];
		}
		
		if (answer > k) {
			System.out.print("Oh no");
		} else {
			System.out.print(answer);
		}
	}
	
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if (parentA == parentB) {
			
			return false;
		} else if (costs[parentA] > costs[parentB]) {
			sets[parentA] = parentB;
		} else {
			sets[parentB] = parentA;
		}
		
		return true;
	}
	
	static int find(int a) {
		if (sets[a] == a) {
			
			return a;
		}
		
		return sets[a] = find(sets[a]);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		answer = 0;
		
		sets = new int[N + 1];
		costs = new int[N + 1];
		hashSet = new HashSet<>();
		
		for (int i = 1; i <= N; ++i) {
			sets[i] = i;
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; ++i) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
	}
}
