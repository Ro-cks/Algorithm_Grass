import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int V;
	static int E;
	static int start;
	static int[] dist;
	static List<Node>[] graph;
	
	private static class Node {
		int num;
		int cost;
		
		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		for (int i = 1; i <= V; ++i) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append('\n');
				
				continue;
			}
			
			sb.append(dist[i]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (now.cost > dist[now.num]) {
				
				continue;
			}
			
			for (Node next : graph[now.num]) {				
				if (dist[next.num] > now.cost + next.cost) {
					dist[next.num] = now.cost + next.cost;
					pq.offer(new Node(next.num, dist[next.num]));
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine().trim());
		
		dist = new int[V + 1];
		
		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
	}
}
