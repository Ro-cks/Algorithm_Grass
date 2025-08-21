import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int M;
	static int N;
	static int O;
	static int P;
	static int Q;
	static int R;
	static int S;
	static int T;
	static int U;
	static int V;
	static int W;
	static int answer;
	static int[][][][][][][][][][][] dist;
	static int[][][][][][][][][][][] tomatoes;
	static Queue<int[]> queue = new LinkedList<>();
	
	static int[][] dirs = { 
							{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
							{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
							{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
							{0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
							{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, 
							{0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0}, 
							{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, 
							{0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0}, 
							{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
							{0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0}, 
							{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
							{0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0}, 
							{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, 
							{0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0}, 
							{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
							{0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0}, 
							{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, 
							{0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0}, 
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, 
							{0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0}, 
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
							{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1} 
							};
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		answer = BFS();
		
		for (int w = 0; w < W; ++w) {
			for (int v = 0; v < V; ++v) {
				for (int u = 0; u < U; ++u) {
					for (int t = 0; t < T; ++t) {
						for (int s = 0; s < S; ++s) {
							for (int r = 0; r < R; ++r) {
								for (int q = 0; q < Q; ++q) {
									for (int p = 0; p < P; ++p) {
										for (int o = 0; o < O; ++o) {
											for (int n = 0; n < N; ++n) {
												for (int m = 0; m < M; ++m) {
													if (tomatoes[w][v][u][t][s][r][q][p][o][n][m] == 0 && dist[w][v][u][t][s][r][q][p][o][n][m] == Integer.MAX_VALUE) {
														answer = -1;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	static int BFS() {
		int maxDays = 0;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			int cw = curr[0];
			int cv = curr[1];
			int cu = curr[2];
			int ct = curr[3];
			int cs = curr[4];
			int cr = curr[5];
			int cq = curr[6];
			int cp = curr[7];
			int co = curr[8];
			int cn = curr[9];
			int cm = curr[10];
			
			maxDays = Math.max(maxDays, dist[cw][cv][cu][ct][cs][cr][cq][cp][co][cn][cm]);
			
			for (int[] dir : dirs) {
				int nw = cw + dir[0];
				int nv = cv + dir[1];
				int nu = cu + dir[2];
				int nt = ct + dir[3];
				int ns = cs + dir[4];
				int nr = cr + dir[5];
				int nq = cq + dir[6];
				int np = cp + dir[7];
				int no = co + dir[8];
				int nn = cn + dir[9];
				int nm = cm + dir[10];
				
				if (nw < 0 || nw >= W || nv < 0 || nv >= V || nu < 0 || nu >= U || nt < 0 || nt >= T || ns < 0 || ns >= S || nr < 0 || nr >= R || nq < 0 || nq >= Q || np < 0 || np >= P || no < 0 || no >= O || nn < 0 || nn >= N || nm < 0 || nm >= M) {
					
					continue;
				}
				
				if (tomatoes[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] != 0) {
					
					continue;
				}
				
				if (dist[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] > dist[cw][cv][cu][ct][cs][cr][cq][cp][co][cn][cm] + 1) {
					dist[nw][nv][nu][nt][ns][nr][nq][np][no][nn][nm] = dist[cw][cv][cu][ct][cs][cr][cq][cp][co][cn][cm] + 1;
					queue.offer(new int[] {nw, nv, nu, nt, ns, nr, nq, np, no, nn, nm});
				}
			}
		}
		
		return maxDays;
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		dist = new int[W][V][U][T][S][R][Q][P][O][N][M];
		tomatoes = new int[W][V][U][T][S][R][Q][P][O][N][M];
		
		for (int w = 0; w < W; ++w) {
			for (int v = 0; v < V; ++v) {
				for (int u = 0; u < U; ++u) {
					for (int t = 0; t < T; ++t) {
						for (int s = 0; s < S; ++s) {
							for (int r = 0; r < R; ++r) {
								for (int q = 0; q < Q; ++q) {
									for (int p = 0; p < P; ++p) {
										for (int o = 0; o < O; ++o) {
											for (int n = 0; n < N; ++n) {
												st = new StringTokenizer(br.readLine().trim());
												Arrays.fill(dist[w][v][u][t][s][r][q][p][o][n], Integer.MAX_VALUE);
												
												for (int m = 0; m < M; ++m) {
													int info = Integer.parseInt(st.nextToken());
													tomatoes[w][v][u][t][s][r][q][p][o][n][m] = info;
													
													if (info == 1) {
														dist[w][v][u][t][s][r][q][p][o][n][m] = 0;
														queue.offer(new int[] {w, v, u, t, s, r, q, p, o, n, m});
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
