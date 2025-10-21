import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int V;
	static int E;
	static int K;
	static final int INF = 600000000;
	static int[] D;
	static List<Node>[] graph;
	
	static class Node {
		int num;
		int cost;
		
		public Node(int v, int cost) {
			this.num = v;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine().trim());
		
		D = new int[V + 1];
		Arrays.fill(D, INF);
		D[K] = 0;
		
		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, cost));
		}
	}
	
	static void solution() {
		dijkstra();
		
		for (int i = 1; i <= V; ++i) {
			if (D[i] != INF) {
				sb.append(D[i]);
			} else {
				sb.append("INF");
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		boolean[] visited = new boolean[V + 1];
		pq.offer(new Node(K, 0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (visited[curr.num]) continue;
			visited[curr.num] = true;
			
			for (Node next : graph[curr.num]) {
				if (visited[next.num]) continue;
				
				if (D[next.num] > D[curr.num] + next.cost) {
					D[next.num] = D[curr.num] + next.cost;
					pq.offer(new Node(next.num, D[next.num]));
				}
			}
		}
	}
}
