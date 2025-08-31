import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int answer;
	static int[] sets;
	static List<Edge> edges;
	
	private static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int cost;
		
		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
		
		public int compareTo(Edge e) {
			
			return Integer.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		int count = 0;
		
		for (Edge edge : edges) {
			if (union(edge.u, edge.v)) {
				++count;
				answer += edge.cost;
				
				if (count == N) {
					
					return;
				}
			}
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
		answer = 0;
		
		sets = new int[N + 1];
		for (int i = 0; i <= N; ++i) {
			sets[i] = i;
		}
		
		edges = new ArrayList<>();
		
		for (int i = 1; i <= N; ++i) {
			int cost = Integer.parseInt(br.readLine().trim());
			edges.add(new Edge(0, i, cost));
		}
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < i + 1; ++j) {
				st.nextToken();
			}
			
			for (int j = i + 1; j < N; ++j) {
				int u = i + 1;
				int v = j + 1;
				int cost = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(u, v, cost));
			}
		}
		
		Collections.sort(edges);
	}
}
