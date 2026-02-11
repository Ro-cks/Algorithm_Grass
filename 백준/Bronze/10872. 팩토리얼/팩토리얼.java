import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
	}
	
	static void solution() {
		dfs(0, 1);
		
		System.out.print(answer);
	}
	
	static void dfs(int depth, int val) {
		if (depth == N) {
			answer = val;
			
			return;
		}
		
		dfs(depth + 1, val * (depth + 1));
	}
}
