import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int W;
	static int H;
	static int answer;
	static int[] sequence;
	static int[][] original;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		perm(0);
	}
	
	// 중복 순열 생성
	static void perm(int depth) {
		if (depth == N) {
			// 생성된 순서로 시뮬레이션
			start();
			
			return;
		}
		
		for (int i = 0; i < W; ++i) {
			sequence[depth] = i;
			perm(depth + 1);
		}
	}
	
	// 시뮬레이션 실행
	static void start() {
		// 복사
		int[][] copy = new int[H][W];
		for (int i = 0; i < H; ++i) {
			copy[i] = Arrays.copyOf(original[i], W);
		}
		
		// 구슬 투하
		for (int i = 0; i < N; ++i) {
			int col = sequence[i];
			
			int row = -1;
			for (int r = 0; r < H; ++r) {
				if (copy[r][col] != 0) {
					row = r;
					
					break;
				}
			}
			
			if (row != -1) {
				bomb(row, col, copy);
				drop(copy);
			}
		}
		
		// 벽돌 수 계산
		int remain = 0;
		for (int r = 0; r < H; ++r) {
			for (int c = 0; c < W; ++c) {
				if (copy[r][c] != 0) {
					++remain;
				}
			}
		}
		
		answer = Math.min(answer, remain);
	}
	
	static void bomb(int r, int c, int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c, map[r][c]});
		map[r][c] = 0;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			int range = curr[2];
			
			for (int d = 0; d < 4; ++d) {
				for (int i = 1; i < range; ++i) {
					int nr = cr + dr[d] * i;
					int nc = cc + dc[d] * i;
					
					if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
					if (map[nr][nc] == 0) continue;
					
					q.offer(new int[] {nr, nc, map[nr][nc]});
					map[nr][nc] = 0;
				}
			}
		}
	}
	
	static void drop(int[][] map) {
		for (int c = 0; c < W; ++c) {
			Queue<Integer> blocks = new LinkedList<>();
			
			for (int r = H - 1; r >= 0; --r) {
				if (map[r][c] != 0) {
					blocks.offer(map[r][c]);
					map[r][c] = 0;
				}
			}
			
			int r = H - 1;
			while (!blocks.isEmpty()) {
				map[r--][c] = blocks.poll();
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		sequence = new int[N];
		
		original = new int[H][W];
		int total = 0;
		for (int r = 0; r < H; ++r) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int c = 0; c < W; ++c) {
				original[r][c] = Integer.parseInt(st.nextToken());
				if (original[r][c] != 0) ++total;
			}
		}
		
		answer = total;
	}
}
