import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int tmp;
	static int blackCount;
	static int whiteCount;
	static boolean[] check1;
	static boolean[] check2;
	static boolean[][] map;
	static List<Point> blackCells;
	static List<Point> whiteCells;
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		tmp = 0;
		blackCount = 0;
		whiteCount = 0;
		
		map = new boolean[N][N];
		check1 = new boolean[2 * N];
		check2 = new boolean[2 * N];
		
		blackCells = new ArrayList<>();
		whiteCells = new ArrayList<>();
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				int input = Integer.parseInt(st.nextToken());
				
				map[i][j] = input == 1;
				if (input == 1) {
					if ((i + j) % 2 == 0) {
						blackCells.add(new Point(i, j));
					} else {
						whiteCells.add(new Point(i, j));
					}
				}
			}
		}
	}
	
	static void solution() {
		dfs(0, 0, blackCells);
		blackCount = tmp;
		
		tmp = 0;
		
		dfs(0, 0, whiteCells);
		whiteCount = tmp;
		
		System.out.print(blackCount + whiteCount);
	}
	
	static void dfs(int index, int count, List<Point> points) {
		if (index == points.size()) {
			tmp = Math.max(tmp, count);
			
			return;
		}
		
		Point p = points.get(index);
		
		if (!(check1[p.r - p.c + (N - 1)] || check2[p.r + p.c])) {
			check1[p.r - p.c + (N - 1)] = true;
			check2[p.r + p.c] = true;
			
			dfs(index + 1, count + 1, points);
			
			check1[p.r - p.c + (N - 1)] = false;
			check2[p.r + p.c] = false;
		}
		
		dfs(index + 1, count, points);
	}
}
