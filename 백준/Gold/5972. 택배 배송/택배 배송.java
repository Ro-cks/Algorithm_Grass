import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] D;
	static List<Node>[] graph;
	
	static final int INF = 50000000;
	
	static class Node {
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
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		D = new int[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			D[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		D[1] = 0;
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, cost));
			graph[v].add(new Node(u, cost));
		}
	}
	
	static void solution() {
		dijkstra();
		
		System.out.print(D[N]);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		boolean[] visited = new boolean[N + 1];
		pq.offer(new Node(1, 0));
		
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