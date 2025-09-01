import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[] sets;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		for (int i = 1; i <= N; ++i) {
			set.add(find(i));
		}
		
		answer = set.size();
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
		
		set = new HashSet<>();
		
		sets = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			sets[i] = i;
		}
	}
}
