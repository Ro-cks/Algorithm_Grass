import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int k;
	static int n;
	static int[] prefixSum = new int[15];
	static int[][] apt = new int[15][15];
	
	public static void main(String[] args) throws IOException {
		for (int i = 1; i < 15; ++i) {
			apt[0][i] = i;
		}
		
		for (int i = 1; i < 15; ++i) {
			for (int j = 1; j < 15; ++j) {
				for (int k = 1; k <= j; ++k) {
					apt[i][j] += apt[i - 1][k];
				}
			}
		}
		
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			k = Integer.parseInt(br.readLine().trim());
			n = Integer.parseInt(br.readLine().trim());
			
			sb.append(apt[k][n]).append('\n');
		}
		
		System.out.print(sb);
	}
}
