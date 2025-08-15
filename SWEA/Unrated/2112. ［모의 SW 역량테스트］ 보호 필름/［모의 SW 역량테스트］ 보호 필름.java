import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int D;
	static int W;
	static int K;
	static int answer;
	static int[] inject;
	static int[][] film;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			sb.append('#').append(tc).append(' ');
			init();
			
			if (K == 1) { 
				sb.append(0).append('\n'); 
				
				continue;
			}
			
			subset(0, 0);
			
			sb.append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void subset(int depth, int count) {
		if (count >= answer) return;
		
		if (depth == D) {
			if (filmTest()) {
				answer = Math.min(answer, count);
			}
			
			return;
		}
		
		inject[depth] = -1;
		subset(depth + 1, count);
		
		inject[depth] = 0;
		subset(depth + 1, count + 1);
		
		inject[depth] = 1;
		subset(depth + 1, count + 1);
	}
	
	static boolean filmTest() {
		outer : for (int w = 0; w < W; ++w) {
					int count = 1;
					
					for (int d = 0; d < D - 1; ++d) {
						int curr = inject[d    ] == -1 ? film[d    ][w] : inject[d    ];
						int next = inject[d + 1] == -1 ? film[d + 1][w] : inject[d + 1];
												
						if (curr == next) {
							++count;
							
							if (count >= K) continue outer;
						} else {
							count = 1;
						}
					}
					
					return false;
				}
		
		return true;
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		D = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = K;
		
		inject = new int[D];
		film = new int[D][W];
		for (int i = 0; i < D; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < W; ++j) {
				film[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}