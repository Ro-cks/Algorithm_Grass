import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[] costs;
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
		
		System.out.print(costs[N]);
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(1, 0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			for (Node next : graph[curr.num]) {
				if (costs[next.num] > costs[curr.num] + next.cost) {
					costs[next.num] = costs[curr.num] + next.cost;
					
					pq.offer(next);
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		costs = new int[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[1] = 0;
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
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
