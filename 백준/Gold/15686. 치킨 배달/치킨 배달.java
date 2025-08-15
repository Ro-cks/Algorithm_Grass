import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int count;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] map;
	static List<int[]> homes;
	static List<int[]> chickens;
	
	public static void main(String[] args) throws IOException {
		init();
		solution();
		
		System.out.print(answer);
	}
    
	static void solution() {
		destroy(0, 0);
	}
	
	static void destroy(int depth, int start) {
		if (depth == M) {
			calc();
			
			return;
		}
		
		for (int i = start; i < chickens.size(); ++i) {
			visited[i] = true;
			destroy(depth + 1, i + 1);
			visited[i] = false;
		}
	}
	
	static void calc() {
		int dist = 0;
		
		for (int[] home : homes) {
			int tmp = Integer.MAX_VALUE;
			
			for (int i = 0; i < chickens.size(); ++i) {
				if (visited[i]) {
					int[] chicken = chickens.get(i);
					tmp = Math.min(tmp, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
				}
			}
			
			dist += tmp;
			if (dist >= answer) return;
		}
		
		answer = Math.min(answer, dist);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chickens.add(new int[] {i, j});
				} else if (map[i][j] == 1) {
					homes.add(new int[] {i, j});
				}
			}
		}
		
		visited = new boolean[chickens.size()];
	}
}