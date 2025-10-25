import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int L;
	static int C;
	static char[] ch;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ch = new char[C];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < C; ++i) {
			ch[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(ch);
	}
	
	static void solution() {
		DFS(0, 0, new StringBuilder());
		
		System.out.print(sb);
	}
	
	static void DFS(int depth, int start, StringBuilder tmp) {
		if (depth == L) {
			if (validation(tmp.toString())) {
				sb.append(tmp.toString()).append('\n');
			}
			
			return;
		}
		
		for (int i = start; i < C; ++i) {
			tmp.append(ch[i]);
			DFS(depth + 1, i + 1, tmp);
			tmp.deleteCharAt(tmp.length() - 1);
		}
	}
	
	static boolean validation(String tmp) {
		int mo = 0;
		int ja = 0;
		
		for (char ch : tmp.toCharArray()) {
			switch (ch) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					++mo;
					break;
				default:
					++ja;
			}
		}
		
		if (mo >= 1 && ja >= 2) {
			
			return true;
		}
		
		return false;
	}
}
