import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static char[] cards;
	static int[][] dp;
	static List<Node>[] graph;
	
	static class Node {
		int town;
		char color;
		
		public Node(int town, char color) {
			this.town = town;
			this.color = color;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		cards = new char[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			char color = st.nextToken().charAt(0);
			cards[i] = color;
		}
		
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new ArrayList[M + 1];
		for (int i = 0; i <= M; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			char color = st.nextToken().charAt(0);
			
			graph[u].add(new Node(v, color));
			graph[v].add(new Node(u, color));
		}
		
		// dp[k][v]: k번째 카드까지 사용 후 v번 마을에 도착 시 최대 점수
		dp = new int[N + 1][M + 1];
		
		for (int i = 0; i <= N; ++i) {
			Arrays.fill(dp[i], -1);
		}
	}
	
	static void solution() {
		dp[0][1] = 0;
		
		for (int k = 0; k < N; ++k) {
			char cardColor = cards[k];
			
			for (int u = 1; u <= M; ++u) {
				if (dp[k][u] == -1) continue;
				
				for (Node node : graph[u]) {
					int v = node.town;
					char edgeColor = node.color;
					
					int currScore = 0;
					if (cardColor == edgeColor) {
						currScore = 10;
					}
					
					int newTotalScore = dp[k][u] + currScore;
					
					dp[k + 1][v] = Math.max(dp[k + 1][v], newTotalScore);
				}
			}
		}
		
		int answer = 0;
		for (int v = 1; v <= M; ++v) {
			answer = Math.max(answer, dp[N][v]);
		}
		
		System.out.print(answer);
	}
}
