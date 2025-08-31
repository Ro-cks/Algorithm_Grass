import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] sets;
	static int[][] D;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
	}
	
	static void solution() {
		for (int k = 1; k <= N; ++k) {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for (int i = 1; i <= N; ++i) {
			int parent = find(i);
			
			map.putIfAbsent(parent, new ArrayList<>());
			
			map.get(parent).add(i);
		}
		
		List<Integer> repres = new ArrayList<>();
		for (List<Integer> m : map.values()) {
			int repre = -1;
			int min = Integer.MAX_VALUE;
			
			for (int candidate : m) {
				int max = 0;
				
				for (int member : m) {
					if (D[candidate][member] > max) {
						max = D[candidate][member];
					}
				}
				
				if (max < min) {
					min = max;
					repre = candidate;
				}
			}
			
			repres.add(repre);
		}
		
		sb.append(map.size()).append('\n');
		
		Collections.sort(repres);
		
		for (int repre : repres) {
			sb.append(repre).append('\n');
		}
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
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		sets = new int[N + 1];
		for (int i = 0; i <= N; ++i) {
			sets[i] = i;
		}
		
		D = new int[N + 1][N + 1];
		for (int i = 0; i <= N; ++i) {
			Arrays.fill(D[i], 101);
			
			D[i][i] = 0;
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
			
			D[a][b] = 1;
			D[b][a] = 1;
		}
	}
}
