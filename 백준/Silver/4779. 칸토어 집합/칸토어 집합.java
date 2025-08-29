import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static char[] answer;
	
	public static void main(String[] args) throws IOException {
		String input;
		while ((input = br.readLine()) != null) {
	        
	        if (input.trim().isEmpty()) {
	            break;
	        }

	        N = Integer.parseInt(input.trim());
	        
	        solution();
	    }
	    
	    System.out.print(sb);
	}
	
	static void solution() {
		cantor(N);
		sb.append('\n');
	}
	
	static void cantor(int N) {
		if (N == 0) {
			
			sb.append('-');
			
			return;
		}
		
		cantor(N - 1);
		
		for (int i = 0; i < Math.pow(3, N - 1); ++i) {
			sb.append(' ');
		}
		
		cantor(N - 1);
	}
}
