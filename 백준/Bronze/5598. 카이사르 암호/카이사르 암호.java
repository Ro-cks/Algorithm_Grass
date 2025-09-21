import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static String input;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		input = br.readLine().trim();
	}
	
	static void solution() {
		int i = 0;
		for (char ch : input.toCharArray()) {
			if (ch > 67) {
				sb.append((char) (ch - 3));
			} else {
				sb.append((char) (ch + 23));
			}
		}
		
		System.out.print(sb);
	}
}
