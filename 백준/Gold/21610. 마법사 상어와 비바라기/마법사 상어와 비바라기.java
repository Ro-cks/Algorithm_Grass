import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static Bucket[][] map;
	static List<Cloud> clouds;
	
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static class Cloud {
		int r;
		int c;
		
		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Bucket {
		int water;
		boolean isTurn;
		
		public Bucket(int water) {
			this.water = water;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		clouds = new ArrayList<>();
		clouds.add(new Cloud(N - 1, 0));
		clouds.add(new Cloud(N - 1, 1));
		clouds.add(new Cloud(N - 2, 0));
		clouds.add(new Cloud(N - 2, 1));
		
		map = new Bucket[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				int water = Integer.parseInt(st.nextToken());
				map[i][j] = new Bucket(water);
			}
		}
	}
	
	static void solution() throws IOException {
		simulator();
		
		int answer = 0;
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				
				answer += map[r][c].water;
				//System.out.print(map[r][c].water + " ");
			}
			
			//System.out.println();
		}
		
		System.out.print(answer);
	}
	
	static void simulator() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int spatium = Integer.parseInt(st.nextToken());
			
			move(dir, spatium);
			
			rain();
			
			remove();
			
			waterCopy();
			
			gen();
		}
	}
	
	static void move(int d, int s) {
		for (Cloud cloud : clouds) {
			int nr = (cloud.r + dr[d] * s) % N;
			int nc = (cloud.c + dc[d] * s) % N;
			
			if (nr < 0) nr += N;
			if (nc < 0) nc += N;
			
			cloud.r = nr;
			cloud.c = nc;
		}
	}
	
	static void rain() {
		for (Cloud cloud : clouds) {
			int r = cloud.r;
			int c = cloud.c;
			
			++map[r][c].water;
		}
	}
	
	static void remove() {
		for (Cloud cloud : clouds) {
			int r = cloud.r;
			int c = cloud.c;
			
			map[r][c].isTurn = true;
		}
		
		clouds.clear();
	}
	
	static void waterCopy() {
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				if (map[r][c].isTurn) {
					int count = 0;
					
					for (int d = 1; d < 8; d += 2) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						
						if (map[nr][nc].water > 0) {
							++count;
						}
					}
					
					map[r][c].water += count;
				}
			}
		}
	}
	
	static void gen() {
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				if (map[r][c].isTurn) {
					map[r][c].isTurn = false;
					
					continue;
				}
				
				if (map[r][c].water >= 2) {
					clouds.add(new Cloud(r, c));
					map[r][c].water -= 2;
				}
			}
		}
	}
}
