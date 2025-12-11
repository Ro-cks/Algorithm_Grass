import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static long[] x;
	static long[] y;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		x = new long[N + 1];
		y = new long[N + 1];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		x[N] = x[0];
		y[N] = y[0];
	}
	
	static void solution() {
		double answer = 0;
		
		for (int i = 0; i < N; ++i) {
			answer += x[i] * y[i + 1];
			answer -= y[i] * x[i + 1];
		}
		answer = answer / 2;
		
		System.out.printf("%.1f", Math.abs(answer));
	}
}
