import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = factorial(N) / (factorial(K) * factorial(N - K));
		
		System.out.println(answer);
	}
	
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} 
		
		return n * factorial(n - 1);
	}
}
