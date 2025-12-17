import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int h;
	static int w;
	static int T;
	static char[][] map;
	static boolean[] hasKey;
	static List<Point>[] waiting;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
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
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new char[h + 2][w + 2];
		hasKey = new boolean[26];
		waiting = new ArrayList[26];
		
		for (int i = 0; i < 26; ++i) {
			waiting[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= h; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 1; j <= w; ++j) {
				map[i][j] = input.charAt(j - 1);
			}
		}
		
		for (int i = 0; i < h + 2; ++i) {
			map[i][0] = '.';
			map[i][w + 1] = '.';
		}
		
		for (int i = 0; i < w + 2; ++i) {
			map[0][i] = '.';
			map[h + 1][i] = '.';
		}
		
		String key = br.readLine().trim();
		if (!key.equals("0")) {
			for (int i = 0; i < key.length(); ++i) {
				char k = key.charAt(i);
				
				hasKey[k - 'a'] = true;
			}
		}
	}
	
	static void solution() {
		int answer = 0;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		boolean[][] visited = new boolean[h + 2][w + 2];
		
		while (!q.isEmpty()) {
			Point curr = q.poll();
			
			if (map[curr.r][curr.c] == '$') {
				++answer;
				
				map[curr.r][curr.c] = '.';
			}
			
			for (int d = 0; d < 4; ++d) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if (nr < 0 || nr >= h + 2 || nc < 0 || nc >= w + 2) continue;
				if (visited[nr][nc]) continue;
				
				if (map[nr][nc] == '*') continue;
				
				visited[nr][nc] = true;
				
				if (map[nr][nc] == '.') {
					q.add(new Point(nr, nc));
					
					continue;
				}
				
				if (map[nr][nc] == '$') {
					q.add(new Point(nr, nc));
					
					continue;
				}
				
				// 열쇠
				if (map[nr][nc] >= 97) {
					hasKey[map[nr][nc] - 'a'] = true;
					
					for (Point next : waiting[map[nr][nc] - 'a']) {
						q.add(next);
					}
					
					q.add(new Point(nr, nc));
					
					continue;
				}
				
				// 문
				if (map[nr][nc] < 97) {
					if (hasKey[map[nr][nc] - 'A']) {
						map[nr][nc] = '.';
						q.add(new Point(nr, nc));
					} else {
						waiting[map[nr][nc] - 'A'].add(new Point(nr, nc));
					}
				}
			}
		}
		
		sb.append(answer).append('\n');
	}
}
