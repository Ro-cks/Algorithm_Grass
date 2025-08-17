import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] costs;
	static int[] answer;
	static int[] indegree;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		for (int i = 1; i <= N; ++i) {
			sb.append(answer[i]).append(' ');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; ++i) {
			if (indegree[i] == 0) {
				pq.offer(i);
				answer[i] = costs[i];
			}
		}
		
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			
			for (int next : graph[curr]) {
				--indegree[next];
				answer[next] = Math.max(answer[next], answer[curr] + costs[next]);
				
				if (indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N + 1];
		indegree[1] = 0;
		answer = new int[N + 1];
		costs = new int[N + 1];
		Arrays.fill(costs, 1);
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			++indegree[to];
		}
	}
}
