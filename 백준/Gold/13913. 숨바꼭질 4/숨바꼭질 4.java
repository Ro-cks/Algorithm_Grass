import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int[] time;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		init();
		
		if (N == K) {
			System.out.println(0);
			System.out.print(N);
		} else {
			solution();
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		parent = new int[100001];
	}
	
	static void solution() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		time[N] = 1;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			if (curr == K) break;
			
			int[] nexts = {curr - 1, curr + 1, curr * 2};
			
			for (int next : nexts) {
				if (next >= 0 && next <= 100000 && time[next] == 0) {
					q.add(next);
					time[next] = time[curr] + 1;
					parent[next] = curr;
				}
			}
		}
		
		sb.append(time[K] - 1).append('\n');
		
		Stack<Integer> path = new Stack<>();
		int temp = K;
		while (temp != N) {
			path.push(temp);
			temp = parent[temp];
		}
		path.push(N);
		
		while (!path.isEmpty()) {
			sb.append(path.pop()).append(' ');
		}
		
		System.out.print(sb);
	}
}
