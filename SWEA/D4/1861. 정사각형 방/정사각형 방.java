import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int room;
	static int answer;
	static int[][] rooms;
	
	static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					solution(i, j);
				}
			}
			
			sb.append('#').append(tc).append(' ').append(room).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution(int r, int c) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c});
		int count = 1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int[] dir : dirs) {
				int nr = cr + dir[0];
				int nc = cc + dir[1];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if (rooms[nr][nc] == rooms[cr][cc] + 1) {
					++count;
					queue.offer(new int[] {nr, nc});
					
					continue;
				}
			}
		}
		
		if (count > answer) {
			answer = count;
			room = rooms[r][c];
		} else if (count == answer) {
			room = Math.min(room, rooms[r][c]);
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		room = (int) Math.pow(N, 2);
		answer = 0;
		
		rooms = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; ++j) {
				rooms[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}