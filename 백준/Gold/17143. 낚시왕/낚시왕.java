import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R;
	static int C;
	static int M;
	static long answer;
	static Shark[][] map;
	static List<Shark> sharks;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		sharks = new ArrayList<>();
		map = new Shark[R][C];
		int idx = 0;
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			switch (d) {
				case 1:
					d = 0;
					break;
				case 2:
					d = 2;
					break;
				case 3:
					d = 1;
					break;
				case 4:
					d = 3;
					break;
				default:
					System.out.println("INVALID INPUT");
			}
			
			sharks.add(new Shark(r, c, s, d, z));
			map[r][c] = sharks.get(idx++);
		}
	}
	
	static void solution() {
		for (int turn = 0; turn < C; ++turn) {
			fishing(turn);
			
			move();
			
			proc();
		}
		
		System.out.print(answer);
	}
	
	static void fishing(int c) {
		for (int r = 0; r < R; ++r) {
			if (map[r][c] != null) {
				answer += map[r][c].z;
				sharks.remove(map[r][c]);
				
				return;
			}
		}
	}
	
	static void move() {
		for (Shark s : sharks) {
			int nr = s.r;
			int nc = s.c;
			
			for (int i = 1; i <= s.s; ++i) {
				nr = nr + dr[s.d];
				nc = nc + dc[s.d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
					nr = nr - dr[s.d];
					nc = nc - dc[s.d];
					
					s.d = (s.d + 2) % 4;
					nr = nr + dr[s.d];
					nc = nc + dc[s.d];
				}
			}
			
			s.r = nr;
			s.c = nc;
		}
	}
	
	static void proc() {
		Shark[][] newMap = new Shark[R][C];
		
		for (Shark s : sharks) {
			int r = s.r;
			int c = s.c;
			if (newMap[r][c] == null) {
				newMap[r][c] = s;
			} else {
				if (newMap[r][c].z < s.z) {
					newMap[r][c] = s;
				}
			}
		}
		
		sharks.clear();
		map = newMap;
		
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				if (map[i][j] != null) {
					sharks.add(map[i][j]);
				}
			}
		}
	}
}
