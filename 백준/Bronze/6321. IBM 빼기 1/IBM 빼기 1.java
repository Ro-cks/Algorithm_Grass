import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/6321
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		String str = "String #";
		char[] alphabet = new char[26];
		for (int i = 0; i < 26; ++i) {
			alphabet[i] = (char) (65 + i);
		}
		
		for (int i = 1; i <= N; ++i) {
			String name = br.readLine();
			
			sb.append(str).append(i).append('\n');
			
			for (char ch : name.toCharArray()) {
				char alpha = alphabet[(ch - 'A' + 1) % 26];
				sb.append(alpha);
			}
			
			sb.append('\n').append('\n');
		}
		
		System.out.print(sb);
	}
}
