import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int length;
	static String answer;
	static String[] files;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		files = new String[N];
		
		for (int i = 0; i < N; ++i) {
			files[i] = br.readLine().trim();
		}
		
		length = files[0].length();
	}
	
	static void solution() {
		outer: for (int i = 0; i < length; ++i) {
			boolean isSame = true;
			char ch = files[0].charAt(i);
			
			for (int j = 1; j < N; ++j) {
				if (ch != files[j].charAt(i)) {
					sb.append('?');
					
					continue outer;
				} else {
					ch = files[j].charAt(i);
				}
			}
			
			sb.append(ch);
		}
		
		System.out.print(sb);
	}
}
