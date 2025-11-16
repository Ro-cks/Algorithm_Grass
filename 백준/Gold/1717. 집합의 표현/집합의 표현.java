import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int m;
	static int[] sets;
	
	static final String YES = "yes";
	static final String NO = "no";
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		sets = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			sets[i] = i;
		}
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cmd == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) sb.append(YES).append('\n');
				else sb.append(NO).append('\n');
			}
		}
		
		System.out.print(sb);
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
		} 

		sets[pb] = pa;
		
		return true;
	}
}
