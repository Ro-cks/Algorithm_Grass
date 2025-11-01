import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
	}
	
	static void solution() {
		DFS(1, 2);
		DFS(1, 3);
		DFS(1, 5);
		DFS(1, 7);
		
		System.out.print(sb);
	}
	
	static void DFS(int depth, int num) {
		if (depth == N) {
			if (isPrime(num)) {
				sb.append(num).append('\n');
			}
			
			return;
		}
		
		for (int i = 1; i < 10; i += 2) {
			if (isPrime(num * 10 + i)) {
				DFS(depth + 1, num * 10 + i);
			}
		}
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; ++i) {
			if (num % i == 0) {
				
				return false;
			}
		}
		
		return true;
	}
}
