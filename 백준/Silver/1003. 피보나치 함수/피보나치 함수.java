import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N;
	static int[] fibo0;
	static int[] fibo1;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		fibo0 = new int[41];
		fibo1 = new int[41];
		
		fibo0[0] = 1;
		fibo0[1] = 0;
		fibo0[2] = 1;
		
		fibo1[0] = 0;
		fibo1[1] = 1;
		fibo1[2] = 1;
		
		for (int i = 3; i < 41; ++i) {
			fibo0[i] = fibo0[i - 1] + fibo0[i - 2];
			fibo1[i] = fibo1[i - 1] + fibo1[i - 2];
		}
		
		for (int i = 0; i < T; ++i) {
			N = Integer.parseInt(br.readLine().trim());
			sb.append(fibo0[N]).append(' ').append(fibo1[N]).append('\n');
		}
		
		System.out.print(sb);
	}
}
