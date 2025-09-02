import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int D;
	static int answer;
	static int[] sequence;
	static int[][] map;
	
	private static class Enemy implements Comparable<Enemy> {
		int r;
		int c;
		int dist;
		
		public Enemy(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		public int compareTo(Enemy e) {
			if (this.dist == e.dist) {
				
				return Integer.compare(this.c, e.c);
			}
			
			return Integer.compare(this.dist, e.dist);
 		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	/* 
	 * 1. 조합으로 궁수 배치
	 * 2. 각 위치마다 BFS
	 * 3. 적을 만나면 적 제거 -> lazy
	 * 3.1 적 제거, count
	 * 4. 적 한칸 아래로 이동
	 * 4.1 맵 밖으로 벗어나는 적은 제거(count 안 함)
	 * */
	static void solution() {
		comb(0, 0);
		
		System.out.print(answer);
	}
	
	static void comb(int depth, int idx) {
		if (depth == 3) {
			int[][] copy = new int[N][M];
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					copy[i][j] = map[i][j];
				}
			}
			
			game(copy);
			
			return;
		}
		
		for (int i = idx; i < M; ++i) {
			sequence[depth] = i;
			comb(depth + 1, i + 1);
		}
	}
	
	static void game(int[][] map) {
		int count = 0;
		
		for (int n = 0; n < N; ++n) {
			List<Enemy>[] list = new ArrayList[3];
			for (int k = 0; k < 3; ++k) {
				list[k] = new ArrayList<>();
			}
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (map[i][j] == 1) {
						for (int k = 0; k < 3; ++k) {
							int dist = calDist(i, j, N, sequence[k]);
							if (dist <= D) {
								list[k].add(new Enemy(i, j, dist));
							}
						}
					}
				}
			}
			
			for (int i = 0; i < 3; ++i) {
				if (list[i].size() == 0) continue;
				
				Collections.sort(list[i]);
				
				if (map[list[i].get(0).r][list[i].get(0).c] != 0) {
					map[list[i].get(0).r][list[i].get(0).c] = 0;
					++count;
				}
			}
			
			for (int i = N - 1; i >= 1; --i) {
				for (int j = 0; j < M; ++j) {
					map[i][j] = map[i - 1][j];
				}
			}
			
			for (int j = 0; j < M; ++j) {
				map[0][j] = 0;
			}
		}
		
		answer = Math.max(answer, count);
	}
	
	static int calDist(int r1, int c1, int r2, int c2) {
		
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		sequence = new int[3];
		
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
			}
		}
	}
}
