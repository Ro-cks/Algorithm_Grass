import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int x;
	static int y;
	static int K;
	static int[] command;
	static int[] line1;
	static int[] line2;
	static int[][] map;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		command = new int[K];
		line1 = new int[4];
		line2 = new int[4];
		
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < K; ++i) {
			command[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for (int i = 0; i < K; ++i) {
			int cmd = command[i] - 1;
			
			int tmp;
			int tmpX = x + dr[cmd];
			int tmpY = y + dc[cmd];
			
			if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M) continue;
			
			x = tmpX;
			y = tmpY;
			
			switch (cmd) {
				case 0:
					tmp = line2[3];
					for (int idx = 3; idx >= 1; --idx) {
						line2[idx] = line2[idx - 1];
					}
					line2[0] = tmp;
					
					line1[0] = line2[0];
					line1[2] = line2[2];
					break;
				case 1:
					tmp = line2[0];
					for (int idx = 0; idx < 3; ++idx) {
						line2[idx] = line2[idx + 1];
					}
					line2[3] = tmp;
					
					line1[0] = line2[0];
					line1[2] = line2[2];
					break;
				case 2:
					tmp = line1[0];
					for (int idx = 0; idx < 3; ++idx) {
						line1[idx] = line1[idx + 1];
					}
					line1[3] = tmp;
					
					line2[0] = line1[0];
					line2[2] = line1[2];
					break;
				case 3:
					tmp = line1[3];
					for (int idx = 3; idx >= 1; --idx) {
						line1[idx] = line1[idx - 1];
					}
					line1[0] = tmp;
					
					line2[0] = line1[0];
					line2[2] = line1[2];
					break;
				default:
					System.out.println("INVALID COMMAND");
			}
			
			if (map[x][y] == 0) {
				map[x][y] = line1[2];
			} else {
				line1[2] = map[x][y];
				line2[2] = map[x][y];
				map[x][y] = 0;
			}
			
			sb.append(line1[0]).append('\n');
		}
		
		System.out.print(sb);
	}
}
