import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < N; ++i) {
			set.add(br.readLine());
		}
		
		String[] words = new String[set.size()];
		Iterator<String> iter = set.iterator();
		for (int i = 0; i < words.length; ++i) {
			words[i] = iter.next();
		}
		
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String word1, String word2) {
				if (Integer.compare(word1.length(), word2.length()) > 0) {
					
					return 1;
				} else if (Integer.compare(word1.length(), word2.length()) == 0) {
					if (word1.compareTo(word2) > 0) {
						
						return 1;
					} else {
						
						return -1;
					}
				} else {
					
					return -1;
				}
			}
		});
		
		for (int i = 0; i < words.length; ++i) {
			sb.append(words[i]).append('\n');
		}
		
		System.out.print(sb);
	}
}
