import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int answer;
	static int[] coins;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
		
		System.out.print(answer);
	}
	
	static void solution() {
		for (int i = N - 1; i >= 0; --i) {
			while (K >= coins[i]) {
				K -= coins[i];
				++answer;
			}
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		coins = new int[N];
		
		for (int i = 0; i < N; ++i) {
			coins[i] = Integer.parseInt(br.readLine().trim());
		}
	}
}
