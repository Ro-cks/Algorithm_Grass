import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[] costs;
	static int[] results;
	static int[] indegree;
	static List<Integer>[] graph;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		for (int i = 1; i <= N; ++i) {
			sb.append(results[i]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		for (int i = 1; i <= N; ++i) {
			if (indegree[i] == 0) {
				pq.offer(i);
				results[i] = costs[i];
			}
		}
		
		BFS();
	}
	
	static void BFS() {
		while(!pq.isEmpty()) {
			int now = pq.poll();
			
			for (int next : graph[now]) {
				results[next] = Math.max(results[next], results[now] + costs[next]);
				--indegree[next];			
				
				if (indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		costs = new int[N + 1];
		results = new int[N + 1];
		indegree = new int[N + 1];
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			costs[i] = Integer.parseInt(st.nextToken());
			
			while (st.hasMoreTokens()) {
				int val = Integer.parseInt(st.nextToken());
				if (val == -1) {
					
					break;
				}
				
				graph[val].add(i);
				++indegree[i];
			}
		}
	}
}
