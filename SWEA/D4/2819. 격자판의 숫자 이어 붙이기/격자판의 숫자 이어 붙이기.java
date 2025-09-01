import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int[][] map;
	static Set<Integer> set;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			for (int i = 0; i < 4; ++i) {
				for (int j = 0; j < 4; ++j) {
					solution(i, j);
				}
			}
			
			output.append('#').append(tc).append(' ').append(set.size()).append('\n');
		}
		
		System.out.print(output);
	}
	
	static void solution(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c, 1,map[r][c]});
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			if(curr[2]==7) {
				set.add(curr[3]);
				continue;
			}
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
				
				q.offer(new int[] {nr, nc, curr[2]+1, curr[3]*10 + map[nr][nc]});
			}
		}
	}
	
	static void init() throws IOException {
		map = new int[4][4];
		set = new HashSet<>();
		
		for (int i = 0; i < 4; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < 4; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
