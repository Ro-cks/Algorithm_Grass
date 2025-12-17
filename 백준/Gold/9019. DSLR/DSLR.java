import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int A;
	static int B;
	
	static char[] cmds = {'D', 'S', 'L', 'R'};
	
	static class Node {
		int num;
		String cmd;
		
		public Node(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; ++t) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		sb.append(bfs(A)).append('\n');
	}
	
	static String bfs(int num) {
		String answer = "";
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(A, ""));
		boolean[] visited = new boolean[10000];
		visited[A] = true;
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			int n = curr.num;
			
			if (n == B) {
				return curr.cmd;
			}
			
			for (int c = 0; c < 4; ++c) {
				int next = 0;
				char command = cmds[c];

				switch (command) {
					case 'D':						
						next = (curr.num * 2) % 10000;
						
						break;
					case 'S':
						next = (curr.num == 0) ? 9999 : curr.num - 1;
						
						break;
					case 'L':
						next = (curr.num % 1000) * 10 + (curr.num / 1000);
						
						break;
					case 'R':
						next = (curr.num % 10) * 1000 + (curr.num / 10);
						
						break;
					default:
				}
				
				if (!visited[next]) {
					visited[next] = true;
					q.add(new Node(next, curr.cmd + command));
				}
			}
		}
		
		return "";
	}
}
