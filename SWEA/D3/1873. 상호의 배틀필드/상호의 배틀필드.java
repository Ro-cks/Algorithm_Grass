import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int H;
	static int W;
	static int N;
	static Tank tank;
	static char[][] map;
	
	static int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	
	private static class Tank {
		private int r;
		private int c;
		private int dir;
		
		public Tank(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
		public void setR(int r) {
			this.r = r;
		}
		
		public void setC(int c) {
			this.c = c;
		}
		
		public void setDir(int dir) {
			this.dir = dir;
		}
		
		public void active(char cmd) {
			switch (cmd) {
				case 'U':
				case 'D':
				case 'L':
				case 'R':
					changeDir(cmd);
					break;
				default:
					shoot();
			}
		}
		
		public void changeDir(char cmd) {
			switch (cmd) {
				case 'U':
					this.dir = 0;
					move();
					break;
				case 'D':
					this.dir = 2;
					move();
					break;
				case 'L':
					this.dir = 3;
					move();
					break;
				default:
					this.dir = 1;
					move();
			}
		}
		
		public void move() {
			int nr = this.r + dirs[dir][0];
			int nc = this.c + dirs[dir][1];
			
			if (map[nr][nc] == '.') {
				this.r = nr;
				this.c = nc;
			}
		}
		
		public void shoot() {
			int nr = r;
			int nc = c;
			
			while (true) {
				nr = nr + dirs[dir][0];
				nc = nc + dirs[dir][1];
				
				if (map[nr][nc] == '#') {
					
					break;
				}
				
				if (map[nr][nc] == '*') {
					map[nr][nc] = '.';
					
					break;
				}
			}
		}
		
		public char getTankShape() {
			switch (dir) {
				case 0:
					
					return '^';
				case 1:
					
					return '>';
				case 2:
					
					return 'v';
				default:
					
					return '<';
			}
		}
		
		@Override
		public String toString() {
			
			return "\nTANK POSITION [" + this.r + ", " + this.c + "]\n" + 
					"TANK DIRECTION: " + this.dir;
		}
	}
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
//			for (int i = 0; i < H + 2; ++i) {
//				System.out.println("\n" + Arrays.toString(map[i]));
//			}
			
			solution();
			
			sb.append('#').append(tc).append(' ');
			
			map[tank.r][tank.c] = tank.getTankShape();
			for (int i = 1; i <= H; ++i) {
				for (int j = 1; j <= W; ++j) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	static void solution() throws IOException {
		String command = br.readLine().trim();
		
		for (int i = 0; i < N; ++i) {
			char cmd = command.charAt(i);
			
			tank.active(cmd);
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		tank = new Tank(0, 0, 0);

		map = new char[H + 2][W + 2];
		for (int i = 1; i <= H; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < W; ++j) {
				char info = input.charAt(j);
				
				switch (info) {
					case '^':
						tank.setR(i);
						tank.setC(j + 1);
						tank.setDir(0);
						map[i][j + 1] = '.';
						break;
					case '>':
						tank.setR(i);
						tank.setC(j + 1);
						tank.setDir(1);
						map[i][j + 1] = '.';
						break;
					case 'v':
						tank.setR(i);
						tank.setC(j + 1);
						tank.setDir(2);
						map[i][j + 1] = '.';
						break;
					case '<':
						tank.setR(i);
						tank.setC(j + 1);
						tank.setDir(3);
						map[i][j + 1] = '.';
						break;
					default:
						map[i][j + 1] = info;
				}
			}
		}
		
		for (int i = 0; i < H + 2; ++i) {
			map[i][0] = '#';
			map[i][W + 1] = '#';
		}
		
		for (int i = 0; i < W + 2; ++i) {
			map[0][i] = '#';
			map[H + 1][i] = '#';
		}
		
		// System.out.println(tank.toString());
		N = Integer.parseInt(br.readLine().trim());
	}
}
