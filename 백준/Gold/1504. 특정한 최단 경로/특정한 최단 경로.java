import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int E;
	static int v1;
	static int v2;
	static long answer;
	static int[] D;
	static int[] v1D;
	static int[] v2D;
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
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		
		D = new int[N + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1] = 0;
		
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, cost));
			graph[v].add(new Node(u, cost));
		}
		
		st = new StringTokenizer(br.readLine().trim());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		v1D = new int[N + 1];
		Arrays.fill(v1D, Integer.MAX_VALUE);
		v1D[v1] = 0;
		
		v2D = new int[N + 1];
		Arrays.fill(v2D, Integer.MAX_VALUE);
		v2D[v2] = 0;
	}
	
	static void solution() {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		q.offer(new Node(1, 0));
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (D[curr.num] < curr.cost) {
		        continue;
		    }
			
			for (Node next : graph[curr.num]) {
				if (D[next.num] > D[curr.num] + next.cost) {
					D[next.num] = D[curr.num] + next.cost;
					q.offer(new Node(next.num, D[next.num]));
				}
			}
		}
		
		q.offer(new Node(v1, 0));
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (v1D[curr.num] < curr.cost) {
		        continue;
		    }
			
			for (Node next : graph[curr.num]) {
				if (v1D[next.num] > v1D[curr.num] + next.cost) {
					v1D[next.num] = v1D[curr.num] + next.cost;
					q.offer(new Node(next.num, v1D[next.num]));
				}
			}
		}
		
		q.offer(new Node(v2, 0));
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (v2D[curr.num] < curr.cost) {
		        continue;
		    }
			
			for (Node next : graph[curr.num]) {
				if (v2D[next.num] > v2D[curr.num] + next.cost) {
					v2D[next.num] = v2D[curr.num] + next.cost;
					q.offer(new Node(next.num, v2D[next.num]));
				}
			}
		}
		
		boolean path1_possible = (D[v1] != Integer.MAX_VALUE && v1D[v2] != Integer.MAX_VALUE && v2D[N] != Integer.MAX_VALUE);
	    boolean path2_possible = (D[v2] != Integer.MAX_VALUE && v2D[v1] != Integer.MAX_VALUE && v1D[N] != Integer.MAX_VALUE);

	    long cost1 = -1;
	    if(path1_possible) {
	        // long으로 캐스팅하여 오버플로우 방지
	        cost1 = (long)D[v1] + v1D[v2] + v2D[N];
	    }

	    long cost2 = -1;
	    if(path2_possible) {
	        cost2 = (long)D[v2] + v2D[v1] + v1D[N];
	    }
		
	    if (cost1 == -1 && cost2 == -1) {
	        answer = -1; // 두 경로 모두 불가능
	    } else if (cost1 == -1) {
	        answer = cost2; // 경로 2만 가능
	    } else if (cost2 == -1) {
	        answer = cost1; // 경로 1만 가능
	    } else {
	        answer = Math.min(cost1, cost2); // 둘 다 가능하면 최솟값
	    }
		
		System.out.print(answer);
	}
}
