import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[] sets;
	static boolean[] isMan;
	static List<Edge> edges;
	
	private static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
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
			if (isMan[edge.from] ^ isMan[edge.to]) {
				if (union(edge.from, edge.to)) {
					++count;
					answer += edge.cost;
				}
				
				if (count == N - 1) {
					
					break;
				}
			}
		}
		
		if (count != N - 1) {
			answer = -1;
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
		answer = 0;
		
		sets = new int[N + 1];
		isMan = new boolean[N + 1];
		edges = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; ++i) {
			sets[i] = i;
			
			isMan[i] = st.nextToken().charAt(0) == 'M';
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(from, to, cost));
		}
		
		Collections.sort(edges);
	}
}
