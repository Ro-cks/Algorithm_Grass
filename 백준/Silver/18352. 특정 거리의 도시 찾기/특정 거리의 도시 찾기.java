import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static int X;
	static int count;
	static int answer;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Node>[] adjList;
	
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
		
		for (int i = 1; i <= N; ++i) {
			if (dist[i] == K) {
				++count;
				sb.append(i).append('\n');
			}
		}
		
        if (count == 0) {
            sb.append(-1);
        }
        
		System.out.print(sb);
	}
	
	static void solution() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		dist[X] = 0;
		pq.add(new Node(X, 0));
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (visited[now.num]) continue;
			
			visited[now.num] = true;
			
			for (Node next : adjList[now.num]) {
				if (dist[next.num] > now.cost + next.cost) {
					dist[next.num] = now.cost + next.cost;
					pq.add(new Node(next.num, dist[next.num]));
				}
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		visited = new boolean[N + 1];
		adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to, 1));
		}
	}
}
