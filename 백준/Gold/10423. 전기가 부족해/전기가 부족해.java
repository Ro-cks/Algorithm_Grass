import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static int answer;
	static int[] sets;
	static int[] elecs;
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
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		for (int i = 1; i < K; ++i) {
			union(elecs[0], elecs[i]);
		}
		
		for (Edge edge : edges) {
			if (union(edge.u, edge.v)) {
				answer += edge.cost;
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
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		sets = new int[N + 1];
		for (int i = 0; i <= N; ++i) {
			sets[i] = i;
		}
		
		elecs = new int[K];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < K; ++i) {
			int num = Integer.parseInt(st.nextToken());
			elecs[i] = num;
		}
		
		edges = new ArrayList<>();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(u, v, cost));
		}
		
		Collections.sort(edges);
	}
}
