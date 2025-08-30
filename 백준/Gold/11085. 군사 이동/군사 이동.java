import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int p;
	static int w;
	static int c;
	static int v;
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
		
		@Override
		public int compareTo(Edge e) {
			
			return Integer.compare(e.cost, this.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		System.out.print(solution());
	}
	
	static int solution() {
		for (Edge edge : edges) {
			
			if (union(edge.u, edge.v)) {
				
				if (find(c) == find(v)) {
					
					return edge.cost;
				}
			}
		}
		
		return -1;
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
		p = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine().trim());
		c = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		sets = new int[p];
		for (int i = 0; i < p; ++i) {
			sets[i] = i;
		}
		
		edges = new ArrayList<>();
		
		for (int i = 0; i < w; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(u, v, cost));
		}
		
		Collections.sort(edges);
	}
}
