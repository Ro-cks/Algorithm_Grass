import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[] sets;
	static List<Integer>[] parties;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		sets = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			sets[i] = i;
		}
		
		st = new StringTokenizer(br.readLine().trim());
		int count = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			
			union(0, a);
		}
		
		parties = new ArrayList[M];
		for (int i = 0; i < M; ++i) {
			parties[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine().trim());
			count = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			parties[i].add(a);
			for (int j = 0; j < count - 1; ++j) {
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
				parties[i].add(b);
			}
		}
	}
	
	static void solution() {
 Outer: for (List<Integer> party : parties) {
			for (int member : party) {
				if (find(member) == find(0)) continue Outer;
			}
			
			++answer;
		}
		
		System.out.print(answer);
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
}
