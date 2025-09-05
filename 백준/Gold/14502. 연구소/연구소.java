import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int[][] map;
	static int[][] sequence;
	static List<int[]> points;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		/* 1. 벽 세울 조합 구하기
		 * 1.1 바이러스가 있는 위치면 continue
		 * 
		 * 2. 원본 배열 복사 -> 벽 세우기
		 * 
		 * 3. 바이러스들로 Flood Fill
		 * 
		 * 4. 맵에 남은 0 개수 count, answer와 비교, max 대입
		 * */
		
		init();
		
		solution();
	}
	
	static void solution() {
		combination(0, 0);
		
		System.out.print(answer);
	}
	
	// 조합이 담긴 sequence를 통해 BFS 시작
	static void BFS(int[][] map, Queue<int[]> q) {
		boolean[][] visited = new boolean[N][M];
		int count = 0;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			visited[cr][cc] = true;
			
			for (int d = 0; d < 4; ++d) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (map[nr][nc] == 1) continue;
				if (map[nr][nc] == 2) continue;
				if (visited[nr][nc]) continue;
				
				map[nr][nc] = 2;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
//		for (int i = 0; i < N; ++i) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		
//		System.out.println("--------------");
		
		// 안전 영역(map에서 0인 부분) 크기 확인
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 0) ++count;
			}
		}
		
		answer = Math.max(answer, count);
	}
	
	// 벽 세울 위치의 조합을 뽑아서 BFS() 호출
	static void combination(int depth, int start) {
		if (depth == 3) {
			Queue<int[]> q = new LinkedList<>();
			for (int[] point : points) {
				q.offer(point);
			}
			
			// map 복사
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; ++i) {
				copy[i] = Arrays.copyOfRange(map[i], 0, M);
			}
			
			// 조합에 따라 벽 세우기
			for (int i = 0; i < 3; ++i) {
				int r = sequence[i][0];
				int c = sequence[i][1];
				
				copy[r][c] = 1;
			}
			
//			for (int i = 0; i < N; ++i) {
//				System.out.println(Arrays.toString(copy[i]));
//			}
//			
//			System.out.println("--------------");
			
			BFS(copy, q);
			
			return;
		}
		
		for (int i = start; i < N * M; ++i) {
			int r = i / M;
			int c = i % M;
			if (map[r][c] == 1 || map[r][c] == 2) continue;
			
			sequence[depth][0] = r;
			sequence[depth][1] = c;
			combination(depth + 1, i + 1);
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MIN_VALUE;
		
		map = new int[N][M];
		sequence = new int[3][2];
		points = new ArrayList<>();
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				
				if (val == 2) {
					points.add(new int[] {i, j});
				}
			}
		}
	}
}
