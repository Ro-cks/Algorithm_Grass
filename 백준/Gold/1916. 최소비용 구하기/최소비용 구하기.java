import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int start;
	static int end;
	static int[] D;
	static boolean[] visited;
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
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (!visited[curr.num]) {
				visited[curr.num] = true;
			} else {
				continue;
			}
			
			for (Node next : graph[curr.num]) {
				if (visited[next.num]) continue;
				
				if (D[next.num] > curr.cost + next.cost) {
					D[next.num] = curr.cost + next.cost;
					pq.offer(new Node(next.num, D[next.num]));
				}
			}
		}
		
		System.out.print(D[end]);
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		D = new int[N + 1];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; ++i) {
			D[i] = Integer.MAX_VALUE;
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, cost));
		}
		
		st = new StringTokenizer(br.readLine().trim());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		D[start] = 0;
	}
}
