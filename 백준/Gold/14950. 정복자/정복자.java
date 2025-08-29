import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int t;
	static int answer;
	static boolean[] visited;
	static List<Node>[] graph;
	
	private static class Node implements Comparable<Node> {
		int num;
		int cost;
		
		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		
		public int compareTo(Node e) {
			
			return Integer.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited[1] = true;
		for (Node next : graph[1]) {
			pq.offer(next);
		}
		
		int alpha = 0;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			int num = curr.num;
			int cost = curr.cost;
			
			if (visited[num]) continue;
			
			visited[num] = true;
			answer += cost + alpha;
			alpha += t;
			
			for (Node next : graph[curr.num]) {
				if (!visited[next.num]) {
					pq.offer(next);
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		answer = 0;
		
		visited = new boolean[N + 1];
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, cost));
			graph[v].add(new Node(u, cost));
		}
	}
}