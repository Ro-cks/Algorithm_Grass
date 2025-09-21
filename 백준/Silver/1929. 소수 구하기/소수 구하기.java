import java.io.*;
import java.util.*;
 
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int M;
	static int N;
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		prime = new boolean[N + 1];
	}
	
	static void solution() {
		get_prime();
		
		for(int i = M; i <= N; i++) {
			// false = 소수 
			if(!prime[i]) sb.append(i).append('\n');
		}
		
		System.out.println(sb);
	}
 
	public static void get_prime() {
		// true = 소수아님 , false = 소수 
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); ++i) {
			if(prime[i]) continue;
			
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
 