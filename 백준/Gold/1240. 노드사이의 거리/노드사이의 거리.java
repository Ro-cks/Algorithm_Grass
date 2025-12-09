import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static List<ArrayList<Node>> graph;
	
	static class Node {
		int num;
		int dist;
		
		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v, d));
			graph.get(v).add(new Node(u, d));
		}
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(start, end)).append('\n');
		}
	}
	
	static int bfs(int start, int target) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		q.add(new Node(start, 0));
		visited[start] = true;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.num == target) {
				
				return curr.dist;
			}
			
			for (Node next : graph.get(curr.num)) {
				if (visited[next.num]) continue;
				
				visited[next.num] = true;
				q.add(new Node(next.num, curr.dist + next.dist));
			}
		}
		
		return -1;
	}
}
