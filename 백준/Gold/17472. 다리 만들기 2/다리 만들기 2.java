import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int answer;
	static int labelCount;
	static int[] sets;
	static int[][] map;
	static List<Edge> edges;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	private static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			
			return Integer.compare(cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] >= 1) {
					conBridge(i, j);
				}
			}
		}
		
		Collections.sort(edges);
		
		int count = 0;
		for (Edge edge : edges) {
			if (union(edge.from, edge.to)) {
				answer += edge.cost;
				
				if (++count == labelCount - 1) {
					
					System.out.print(answer);
					System.exit(0);
				}
			}
		}
		
		System.out.print(-1);
	}
	
	static void conBridge(int r, int c) {
		for (int d = 0; d < 4; ++d) {
			int length = 0;
			int nr = r;
			int nc = c;
			
			while (true) {
				nr += dr[d];
				nc += dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					
					break;
				}
				
				if (map[nr][nc] == 0) {
					++length;
				} else {
					if (length < 2) {
						
						break;
					}
					
					if (map[nr][nc] == map[r][c]) {
						
						break;
					}
					
					edges.add(new Edge(map[nr][nc], map[r][c], length));
					
					break;
				}
			}
		}
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) {
			
			return false;
		}
		
		if (pa < pb) {
			sets[pb] = pa;
		} else {
			sets[pa] = pb;
		}
		
		return true;
	}
	
	static int find(int a) {
		if (sets[a] == a) {
			
			return a;
		}
		
		return sets[a] = find(sets[a]);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		labelCount = 0;
		answer = 0;
		
		edges = new ArrayList<>();
		
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < M; ++j) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val == 1 ? -1 : 0;
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] != -1) {
					
					continue;
				}
				
				++labelCount;
				labeling(i, j);
			}
		}
		
		sets = new int[labelCount + 1];
		for (int i = 1; i <= labelCount; ++i) {
			sets[i] = i;
		}
	}
	
	static void labeling(int r, int c) {
		map[r][c] = labelCount;
		
		for (int d = 0; d < 4; ++d) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
				
				continue;
			}
			
			if (map[nr][nc] != -1) {
				
				continue;
			}
			
			labeling(nr, nc);
		}
	}
}
