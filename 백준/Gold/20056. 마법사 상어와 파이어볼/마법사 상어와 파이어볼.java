import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, K;
	static int answer;
	static int[][] counts;
	static List<Ball>[][] balls;
	
	static class Ball {
		int m;
		int d;
		int s;
		
		public Ball(int m, int d, int s) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		counts = new int[N][N];
		
		balls = new ArrayList[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				balls[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			balls[r][c].add(new Ball(m, d, s));
		}
	}
	
	static void solution() {
		simulator();
		
		System.out.print(answer);
	}
	
	static void simulator() {
		for (int k = 0; k < K; ++k) {
			
			List<Ball>[][] nextBalls = new ArrayList[N][N];
			for (int r = 0; r < N; ++r) {
				for (int c = 0; c < N; ++c) {
					nextBalls[r][c] = new ArrayList<>();
				}
			}
			
			for (int r = 0; r < N; ++r) {
				for (int c = 0; c < N; ++c) {
					for (Ball ball : balls[r][c]) {
						int nr = (r + dr[ball.d] * (ball.s % N) + N) % N;
						int nc = (c + dc[ball.d] * (ball.s % N) + N) % N;
						nextBalls[nr][nc].add(ball);
					}
				}
			} // end of move
			
			balls = nextBalls;
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (balls[i][j].size() > 1) {
						merge(i, j);
					}
				}
			} // end of merge
		} // end of simulator
		
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				for (Ball ball : balls[r][c]) {
					answer += ball.m;
				}
			}
		}
	}
	
	static void merge(int r, int c) {
		int mSum = 0;
		int sSum = 0;
		int flag = balls[r][c].get(0).d % 2;
		boolean isSame = false;
		
		for (Ball ball : balls[r][c]) {
			mSum += ball.m;
			sSum += ball.s;
			
			if (ball.d % 2 != flag) {
				isSame = true;
			}
		}
		
		int nm = mSum / 5;
		int ns = sSum / balls[r][c].size();
		
		balls[r][c].clear();
		if (nm == 0) {
			
			return;
		}
		
		divide(r, c, nm, ns, isSame);
	}
	
	static void divide(int r, int c, int nm, int ns, boolean isSame) {
		if (!isSame) {
			for (int d = 0; d < 8; d += 2) {
				balls[r][c].add(new Ball(nm, d, ns));
			}
		} else {
			for (int d = 1; d < 8; d += 2) {
				balls[r][c].add(new Ball(nm, d, ns));
			}
		}
	}
}
