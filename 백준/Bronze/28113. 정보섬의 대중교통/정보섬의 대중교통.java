import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int A;
	static int B;
	static String answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		B = Math.max(N, B);
		
		if (A == B) {
			answer = "Anything";
		} else if (A < B) {
			answer = "Bus";
		} else {
			answer = "Subway";
		}
		
		System.out.print(answer);
	}
}
