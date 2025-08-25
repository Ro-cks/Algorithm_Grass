import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int n;
	static int k;
	static int m;
	
	static int[] sets;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("Scenario ").append(tc).append(':').append('\n');
			
			init();
			
			solution();
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() throws IOException {
		k = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		m = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if (find(u) == find(v)) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
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
		n = Integer.parseInt(br.readLine().trim());
		sets = new int[n];
		for (int i = 0; i < n; ++i) {
			sets[i] = i;
		}
	}
}
