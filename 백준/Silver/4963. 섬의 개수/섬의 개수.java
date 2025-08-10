import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int w;
	static int h;
	static int island;
	static int[][] grid;
	static boolean[][] visited;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
	
	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) {
				
				break;
			}
			
			island = 0;
			grid = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; ++i) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < w; ++j) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < w; ++j) {
					if (!visited[i][j] && grid[i][j] == 1) {
						bfs(new int[] {i, j});
					}
				}
			}
			
			sb.append(island).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		
		++island;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			visited[x][y] = true;
			
			for (int[] dir : dirs) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
					
					continue;
				}
				
				if (grid[nx][ny] == 0 || visited[nx][ny]) {
					
					continue;
				}
				
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
			}
		}
	}
}
