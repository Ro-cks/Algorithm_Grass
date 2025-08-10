import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int paint = 0;
	static int maxSize = 0;
	static int paper[][];
	
	static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; ++j) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				bfs(new int[] {i, j});
			}
		}
		
		System.out.println(paint);
		System.out.print(maxSize);
	}
	
	static void bfs(int[] start) {
		int x = start[0];
		int y = start[1];
		
		if (paper[x][y] < 1) {
			
			return;
		}
		
		++paint;
		int size = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		paper[x][y] = -1;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int cx = current[0];
			int cy = current[1];
			
			++size;
			
			for (int[] dir : dirs) {
				int nx = cx + dir[0];
				int ny = cy + dir[1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					
					continue;
				}
				
				if (paper[nx][ny] == 0 || paper[nx][ny] == -1) {
					
					continue;
				}
				
				paper[nx][ny] = -1;
				queue.offer(new int[] {nx, ny});
			}
		}
		
		maxSize = (size > maxSize) ? size : maxSize;
	}
}
