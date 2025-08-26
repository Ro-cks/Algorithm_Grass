import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static double E;
	static double answer;
	static long[] xs;
	static long[] ys;
	static int[] parents;
	static List<Edge> edges;
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double cost;
		
		public Edge(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			
			return Double.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			answer = solution();
			
			sb.append('#').append(tc).append(' ').append(Math.round(answer)).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static double solution() {		
		int count = 0;
		double answer = 0;
		
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				answer += e.cost;
				
				if (++count == N - 1) {
					
					break;
				}
			}
		}
		
		return answer;
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) {
			
			return false;
		}
		
		parents[pb] = pa;
		
		return true;
	}
	
	static int find(int a) {
		if (parents[a] == a) {
			
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		xs = new long[N];
		ys = new long[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			xs[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			ys[i] = Integer.parseInt(st.nextToken());
		}
		
		E = Double.parseDouble(br.readLine().trim());
		
		parents = new int[N];
		for (int i = 0; i < N; ++i) {
			parents[i] = i;
		}
		
		edges = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) {
				long dx = xs[i] - xs[j];
				long dy = ys[i] - ys[j];
				long dist = dx * dx + dy * dy;
				double cost = E * dist;
				
				edges.add(new Edge(i, j, cost));
			}
		}
		Collections.sort(edges);
	}
}
