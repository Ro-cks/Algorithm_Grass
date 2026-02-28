import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static String input;
	static String[] words;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		input = br.readLine().trim();
		
		words = new String[] {
	        "aespa", "baekjoon", "cau", "debug", "edge", "firefox", "golang", "haegang",
	        "iu", "java", "kotlin", "lol", "mips", "null", "os", "python", "query",
	        "roka", "solvedac", "tod", "unix", "virus", "whale", "xcode", "yahoo", "zebra"
	    };
	}
	
	static void solution() {
		int length = input.length();
		int idx = 0;
		
		while (idx < length) {
			char ch = input.charAt(idx);
			int wordIdx = ch - 'a';
			
			String word = words[wordIdx];
			
			if (input.startsWith(word, idx)) {
				sb.append(ch);
				idx += word.length();
			} else {
				System.out.print("ERROR!");
				System.exit(0);
			}
		}
		
		System.out.println("It's HG!");
		System.out.print(sb.toString());
	}
}
