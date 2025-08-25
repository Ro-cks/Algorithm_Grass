import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] sets;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				int conn = Integer.parseInt(st.nextToken());
				
				if (conn == 1) {
					union(i + 1, j + 1);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine().trim());
		int num = Integer.parseInt(st.nextToken());
		int parentNum = find(num);
		
		for (int i = 0; i < M - 1; ++i) {
			if (parentNum != find(Integer.parseInt(st.nextToken()))) {
				System.out.print("NO");
				
				return;
			}
		}
		
		System.out.print("YES");
	}
	
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if (parentA == parentB) {
			
			return false;
		} else if (parentA > parentB) {
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
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		sets = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			sets[i] = i;
		}
	}
}
