import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int answer;
	static int[][] map;
	static int[][] wormHole;
	static boolean[] isFirstWorm;
	
	// 북 동 남 서
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	private static class Ball {
		int r;
		int c;
		int dir;
		int score;
		
		public Ball(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			for (int r = 1; r < N + 1; ++r) {
				for (int c = 1; c < N + 1; ++c) {
					if (map[r][c] == 0) {
						map[r][c] = -1;
						move(r, c);
						map[r][c] = 0;
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void move(int r, int c) {
		for (int d = 0; d < 4; ++d) {
			Ball ball = new Ball(r, c, d);
			
			while (true) {
				while (true) {
					ball.r += dr[ball.dir];
					ball.c += dc[ball.dir];
					
					if (map[ball.r][ball.c] != 0) break;
				}
				
				// black hole
				if (map[ball.r][ball.c] == -1) {
					answer = Math.max(answer, ball.score);
					
					break;
				// worm hole
				} else if (map[ball.r][ball.c] > 5) {
					int num = map[ball.r][ball.c];
					
					if (wormHole[num][0] == ball.r && wormHole[num][1] == ball.c) {
						ball.r = wormHole[num][2];
						ball.c = wormHole[num][3];
					} else {
						ball.r = wormHole[num][0];
						ball.c = wormHole[num][1];
					}
				// block
				} else {
					ball.dir = changeDir(map[ball.r][ball.c], ball.dir);
					
					ball.score++;
				}
			}
		}
	}
	
	static int changeDir(int block, int dir) {
		switch (block) {
			case 1:
				switch (dir) { // ㅗ ㅏ ㅜ ㅓ
					case 0:
						
						return 2;
					case 1:
						
						return 3;
					case 2:
						
						return 1;
					default:
						
						return 0;
					}
			case 2:
				switch (dir) { // ㅗ ㅏ ㅜ ㅓ
					case 0:
						
						return 1;
					case 1:
						
						return 3;
					case 2:
						
						return 0;
					default:
						
						return 2;
					}
			case 3:
				switch (dir) { // ㅗ ㅏ ㅜ ㅓ
					case 0:
						
						return 3;
					case 1:
						
						return 2;
					case 2:
						
						return 0;
					default:
						
						return 1;
					}
			case 4:
				switch (dir) { // ㅗ ㅏ ㅜ ㅓ
					case 0:
						
						return 2;
					case 1:
						
						return 0;
					case 2:
						
						return 3;
					default:
						
						return 1;
					}
			default:
				return (dir + 2) % 4;
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		answer = Integer.MIN_VALUE;
		map = new int[N + 2][N + 2];
		wormHole = new int[11][4];
		isFirstWorm = new boolean[11];
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 1; j <= N; ++j) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				
				if (val > 5) {
					if (!isFirstWorm[val]) {
						wormHole[val][0] = i;
						wormHole[val][1] = j;
						isFirstWorm[val] = true;
					} else {
						wormHole[val][2] = i;
						wormHole[val][3] = j;
					}
				}
			}
		}
		
		for (int i = 0; i <= N + 1; ++i) {
			map[i][0] = 5;		// 왼쪽 벽
			map[0][i] = 5;		// 위쪽 벽
			map[i][N + 1] = 5;	// 오른쪽 벽
			map[N + 1][i] = 5;	// 아래쪽 벽
		}
	}
}