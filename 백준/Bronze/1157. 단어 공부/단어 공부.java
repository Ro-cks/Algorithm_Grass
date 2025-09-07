import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine().trim().toUpperCase();
		
		char[] alphabet = new char[26];
		
		for (char ch : input.toCharArray()) {
			++alphabet[ch - 'A'];
		}
		
		int maxCount = 0;
		int idx = 0;
		for (int i = 0; i < 26; ++i) {
			if (alphabet[i] > maxCount) {
				maxCount = alphabet[i];
				idx = i;
			}
		}
		
		int secondIdx = -1;
		for (int i = 0; i < 26; ++i) {
			if (maxCount == alphabet[i]) {
				if (i == idx) continue;
				
				secondIdx = i;
			}
		}
		
		if (secondIdx != -1) {
			System.out.print("?");
		} else {
			System.out.print((char) (idx + 'A'));
		}
	}
}
