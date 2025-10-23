import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] A;
	static int[] D;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		A = new int[N + 1];
		D = new int[N + 1];
		
		for (int i = 0; i < N; ++i) {
			A[i + 1] = Integer.parseInt(br.readLine().trim());
		}
	}
	
	static void solution() {
		if (N == 1) {
			System.out.print(A[1]);
			
			return;
		} else if (N == 2) {
			System.out.print(A[1] + A[2]);
			
			return;
		} else {
			D[1] = A[1];
			D[2] = A[1] + A[2];
		}
		                                                                                                         
		for (int i = 3; i <= N; ++i) {
			D[i] = Math.max(D[i - 1], Math.max(D[i - 3] + A[i - 1] + A[i], D[i - 2] + A[i]));
		}
		
		System.out.print(D[N]);
	}
}
