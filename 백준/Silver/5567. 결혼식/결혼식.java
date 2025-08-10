import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static final int L = 2;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		
		for (int i = 0; i <= N; ++i) {
			list[i] = new ArrayList<>();
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		dfs(0, 1);
		
		for (int i = 2; i < visited.length; ++i) {
			if (visited[i]) {
				++answer;
			}
		}
		
		System.out.print(answer);
	}
	
	static void dfs(int depth, int start) {
		if (depth == L) {
			
			return;
		}
		
		for (int num : list[start]) {			
			visited[num] = true;
			dfs(depth + 1, num);
		}
	}
}
