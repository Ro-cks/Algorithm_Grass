import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int V;
	static int E;
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
			
			return Integer.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		int answer = solution();
		
		System.out.print(answer);
	}
	
	static int solution() {
		int count = 0;
		int answer = 0;
		
		for (Edge edge : edges) {
			if (union(edge.u, edge.v)) {
				++count;
				answer += edge.cost;
				
				if (count == V - 1) break;
			}
		}
		
		return answer;
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		sets = new int[V + 1];
		for (int i = 1; i <= V; ++i) {
			sets[i] = i;
		}
		
		edges = new ArrayList<>();
		
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(u, v, cost));
		}
		
		Collections.sort(edges);
	}
}
