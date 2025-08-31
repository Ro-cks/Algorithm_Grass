import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static String input;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution(input.length());
		}
		
		System.out.print(sb);
	}
	
	static void solution(int size) {
		if (size == 1) {
			sb.append("YES").append('\n');
			
			return;
		}
		
		int mid = size / 2;
		for (int i = 0; i < mid; ++i) {
			if (input.charAt(i) - '0' == input.charAt(mid * 2 - i) - '0') {
				sb.append("NO").append('\n');
				
				return;
			}
		}
		
		solution(mid);
	}
	
	static void init() throws IOException {
		input = br.readLine().trim();
	}
}
