import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int answer = Integer.MAX_VALUE;
	static boolean isGM = false;
	static int[] populations;
	static boolean[] sets;
	static boolean[] visited;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		if (!isGM) answer = -1;
		System.out.print(answer);
	}
	
	static void solution() {
		comb(1);
	}
	
	static void comb(int depth) {
		int trueCount = 0;
		int falseCount = 0;
		int trueStart = 0;
		int falseStart = 0;
		for (int i = 1; i <= N; ++i) {
			if (sets[i]) {
				++trueCount;
				trueStart = i;
			} else {
				++falseCount;
				falseStart = i;
			}
		}
		
		if (trueCount != 0 && falseCount != 0) {
			visited = new boolean[N + 1];
			int trueCity = DFS(true, trueStart);
			visited = new boolean[N + 1];
			int falseCity = DFS(false, falseStart);
			
			if (trueCount == trueCity && falseCount == falseCity) {
				isGM = true;
                
				int truePop = 0;
				int falsePop = 0;
				
				for (int i = 1; i <= N; ++i) {
					if (sets[i]) truePop += populations[i];
					else falsePop += populations[i];
				}

				answer = Math.min(answer, Math.abs(truePop - falsePop));
			}
		}
		
		if (depth == N) {
			
			return;
		}
		
		sets[depth] = true;
		comb(depth + 1);
		sets[depth] = false;
		comb(depth + 1);
	}
	
	static int DFS(boolean isTrue, int curr) {
		int count = 1;
		visited[curr] = true;
		
		for (int next : graph[curr]) {
			if (!visited[next] && (sets[curr] == sets[next])) {
				count += DFS(isTrue, next);
			}
		}
		
		return count;
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		populations = new int[N + 1];
		sets = new boolean[N + 1];
		visited = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; ++i) {
			populations[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int count = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < count; ++j) {
				int city = Integer.parseInt(st.nextToken());
				
				graph[i].add(city);
			}
		}
	}
}
