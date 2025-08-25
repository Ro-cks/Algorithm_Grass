import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int m;
	static int[] sets;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() throws IOException {
		int count = 1;
		
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (!union(a, b) && count >= 3) {
				System.out.print(count);
				System.exit(0);
			}
			
			++count;
		}
		
		System.out.print(0);
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
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sets = new int[n];
		for (int i = 0; i < n; ++i) {
			sets[i] = i;
		}
	}
}
