import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
	}
	
	static void solution() {
		int left = 1;
		int right = 1;
		int count = 1;
		int sum = 1;
		
		while (right != N) {
			if (sum == N) {
				++count;
				++right;
				sum += right;
			} else if (sum > N) {
				sum -= left;
				++left;
			} else {
				++right;
				sum += right;
			}
		}
		
		System.out.print(count);
	}
}
