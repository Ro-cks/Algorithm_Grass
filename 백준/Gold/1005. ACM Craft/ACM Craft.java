import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int K;
	static int W;
	static int answer;
	static int[] dp;
	static int[] times;
	static int[] indegrees;
	static List<Node>[] graph;
	
	private static class Node {
		int num;
		int time;
		
		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		
		dp = new int[N + 1];
		indegrees = new int[N + 1];
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		times = new int[N + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; ++i) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			++indegrees[v];
			graph[u].add(new Node(v, times[v]));
		}
		
		W = Integer.parseInt(br.readLine().trim());
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.time, o1.time));
		int max = 0;
		
		for (int i = 1; i <= N; ++i) {
			if (indegrees[i] == 0) {
				pq.offer(new Node(i, times[i]));
				dp[i] = times[i];
			}
		}
		
		BFS(pq);
		
		sb.append(dp[W]).append('\n');
	}
	
	static void BFS(PriorityQueue<Node> pq) {
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
						
			for (Node next : graph[curr.num]) {
				dp[next.num] = Math.max(dp[next.num], dp[curr.num] + times[next.num]);

				--indegrees[next.num];
				
				if (indegrees[next.num] == 0) {
					
					pq.offer(next);
				}
			}
		}
	}
}
