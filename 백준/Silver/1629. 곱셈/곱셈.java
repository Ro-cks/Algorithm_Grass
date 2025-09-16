import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int A;
	static int B;
	static int C;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		 answer = pow(A, B);
		 
		 System.out.print(answer);
	}
	
	static long pow(long A, long exponent) {
		if (exponent == 1) {
			
			return A % C;
		}
		
		long temp = pow(A, exponent / 2);
		
		if (exponent % 2 == 1) {
			
			return (temp * temp % C) * A % C;
		}
		
		return temp * temp % C;
	}
}
