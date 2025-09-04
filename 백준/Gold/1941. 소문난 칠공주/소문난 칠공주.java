import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int answer;
	static int[][] princesses;
	static char[][] map;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() {
		combination(0, 0);
		
		System.out.print(answer);
	}
	
	static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		boolean[][] visited = new boolean[5][5];
		visited[r][c] = true;
		
		int count = 0;
		++count;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
				if (visited[nr][nc]) continue;
				
				boolean isOneOfSeven = false;
				for (int i = 0; i < 7; ++i) {
					if (nr == princesses[i][0] && nc == princesses[i][1]) {
						isOneOfSeven = true;
						
						break;
					}
				}
				
				if (isOneOfSeven) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
					++count;
				}
			}
		}
		
		if (count == 7) {
			int countS = 0;
			
			for (int i = 0; i < 7; ++i) {
				if (map[princesses[i][0]][princesses[i][1]] == 'S') {
					++countS;
				}
			}
			
			if (countS >= 4) {
				++answer;
			}
		}
	}
	
	static void combination(int depth, int start) {
		if (depth == 7) {
			BFS(princesses[0][0], princesses[0][1]);
			
			return;
		}
		
		for (int i = start; i < 25; ++i) {
			int r = i / 5;
			int c = i % 5;
			
			princesses[depth][0] = r;
			princesses[depth][1] = c;
			combination(depth + 1, i + 1);
		}
	}
	
	static void init() throws IOException {
		answer = 0;
		
		map = new char[5][5];
		princesses = new int[7][2];
		
		for (int i = 0; i < 5; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < 5; ++j) {
				map[i][j] = input.charAt(j);
			}
		}
	}
}
