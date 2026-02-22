import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		parents = new int[N + 1];
		
		for (int i = 1; i <= N; ++i) {
			parents[i] = i;
		}
		
		for (int i = 0; i < N - 2; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
	}
	
	static void solution() {
		for (int i = 2; i <= N; ++i) {
			if (find(1) != find(i)) {
				System.out.print("1 " + i);
				
				System.exit(0);
			}
		}
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) {
			
			return false;
		} else if (rootA > rootB) {
			parents[rootA] = rootB;
		} else if (rootA < rootB) {
			parents[rootB] = rootA;
		}
		
		return true;
	}
	
	static int find(int a) {
		if (parents[a] == a) {
			
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
}
