import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] degree;
	static int[][] adjArr;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		degree = new int[N];
		adjArr = new int[N][N];
		
		int a = 0;
		int b = 0;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			
			++degree[a];
			++degree[b];
			adjArr[a][b] = 1;
			adjArr[b][a] = 1;
		}
	}
	
	static void solution() {
		int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (adjArr[i][j] == 1) {
					for (int k = j + 1; k < N; ++k) {
						if (adjArr[i][k] == 1 && adjArr[j][k] == 1) {
							answer = Math.min(answer, degree[i] + degree[j] + degree[k] - 6);
						}
					}
				}
			}
		}
		
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		
		System.out.print(answer);
	}
}
