import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n;
	static int m;
	static int r;
	static int t;
	static int[] items;
	static int[][] D;
	
	static final int INF = 100_000_000;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		items = new int[n + 1];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= n; ++i) {
			int count = Integer.parseInt(st.nextToken());
			items[i] = count;
		}
		
		D = new int[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			Arrays.fill(D[i], INF);
			D[i][i] = 0;
		}
		
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			D[a][b] = l;
			D[b][a] = l;
		}
	}
	
	static void solution() {
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if (D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		int answer = 0;
		
		for (int i = 1; i <= n; ++i) {
			int tmp = 0;
			
			for (int j = 1; j <= n; ++j) {
				if (D[i][j] <= m) {
					tmp += items[j];
				}
			}
			
			answer = Math.max(answer, tmp);
		}
		
		System.out.print(answer);
	}
}
