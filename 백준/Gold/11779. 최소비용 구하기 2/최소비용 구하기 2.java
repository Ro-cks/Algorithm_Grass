import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int start;
	static int end;
	static int[][] D;
	static boolean[] visited;
	static List<Node>[] graph;
	
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
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		visited = new boolean[N + 1];
		D = new int[N + 1][2];
		
		for (int i = 1; i <= N; ++i) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
		}
		
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
		}
		
		st = new StringTokenizer(br.readLine().trim());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		D[start][0] = 0;
		D[start][1] = 0;
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (visited[curr.num]) continue;
			visited[curr.num] = true;
			
			for (Node next : graph[curr.num]) {
				if (D[next.num][0] > D[curr.num][0] + next.cost) {
					D[next.num][0] = D[curr.num][0] + next.cost;
					D[next.num][1] = curr.num;
					pq.offer(new Node(next.num, D[next.num][0]));
				}
			}
		}
		
		sb.append(end);
		
		int preNum = end;
		int count = 1;
		while (true) {
			preNum = D[preNum][1];
			++count;
			sb.insert(0, ' ');
			
			if (preNum == start) {
				
				break;
			}
			
			sb.insert(0, preNum);
		}
		
		sb.insert(0, start);
		sb.insert(0, '\n');
		sb.insert(0, count);
		sb.insert(0, '\n');
		sb.insert(0, D[end][0]);
		
		System.out.print(sb);
	}
}
