import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int X;
	static int answer;
	static int[] D;
	static int[] rD;
	static List<Node>[] graph;
	static List<Node>[] rGraph;
	
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
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		answer = 0;
		
		D = new int[N + 1];
		rD = new int[N + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		Arrays.fill(rD, Integer.MAX_VALUE);
		D[X] = 0;
		rD[X] = 0;
		
		graph = new ArrayList[N + 1];
		rGraph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
			rGraph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, cost));
			rGraph[v].add(new Node(u, cost));
		}
	}
	
	static void solution() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(X, 0));
		
		// X로부터 모든 마을까지의 최단 거리
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for (Node next : graph[curr.num]) {
				if (D[next.num] > D[curr.num] + next.cost) {
					D[next.num] = D[curr.num] + next.cost;
					q.offer(next);
				}
			}
		}
		
		q.offer(new Node(X, 0));
		
		// 모든 마을로부터 X까지의 최단 거리
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			for (Node next : rGraph[curr.num]) {
				if (rD[next.num] > rD[curr.num] + next.cost) {
					rD[next.num] = rD[curr.num] + next.cost;
					q.offer(next);
				}
			}
		}
		
		for (int i = 1; i <= N; ++i) {
			answer = Math.max(answer, D[i] + rD[i]);
		}
		
		System.out.print(answer);
	}
}
