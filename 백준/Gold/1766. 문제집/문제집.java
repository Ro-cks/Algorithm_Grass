import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] indegree;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N + 1];
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			++indegree[B];
			graph[A].add(B);
		}
	}
	
	static void solution() {
		int[] answer = new int[N + 1];
		int idx = 1;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; ++i) {
			if (indegree[i] == 0) {
				pq.add(i);
			}
		}
		
		while (!pq.isEmpty()) {
			int curr = pq.poll();
			
			answer[idx++] = curr;
			
			for (int next : graph[curr]) {
				--indegree[next];
				
				if (indegree[next] == 0) {
					pq.add(next);
				}
			}
		}
		
		for (int i = 1; i <= N; ++i) {
			sb.append(answer[i]).append(' ');
		}
		
		System.out.print(sb);
	}
}
