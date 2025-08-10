import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[][] grid;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; ++j) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				bfs(new int[] {i, j});
			}
		}
		
		System.out.print(answer);
	}
	
	static void bfs(int[] start) {
		int x = start[0];
		int y = start[1];
		if (grid[x][y] < 1) {
			
			return;
		}
		
		++answer;
		grid[x][y] = -1;
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for (int[] dir : dirs) {
				int nx = cx + dir[0];
				int ny = cy + dir[1];
				
				if (nx < 0 || nx >= N ||  ny < 0 || ny >= M) {
					
					continue;
				}
				
				if (grid[nx][ny] == 0 || grid[nx][ny] == -1) {
					
					continue;
				}
				
				grid[nx][ny] = -1;
				queue.offer(new int[] {nx, ny});
			}
		}
	}
}
