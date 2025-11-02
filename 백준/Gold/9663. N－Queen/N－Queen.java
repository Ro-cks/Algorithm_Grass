import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int answer;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		answer = 0;
		arr = new int[N];
	}
	
	static void solution() {
		dfs(0);
		
		System.out.print(answer);
	}
	
	static void dfs(int row) {
		if (row == N) {
			++answer;
			
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			arr[row] = i;
			if (check(row)) {
				dfs(row + 1);
			}
		}
	}
	
	static boolean check(int row) {
		for (int i = 0; i < row; ++i) {
			if (arr[i] == arr[row]) {
				
				return false;
			}
			
			if (Math.abs(row - i) == Math.abs(arr[i] - arr[row])) {
				
				return false;
			}
		}
		
		return true;
	}
}
