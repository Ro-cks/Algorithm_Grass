import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> keyByInteger = new HashMap<>();
		Map<String, Integer> keyByString = new HashMap<>();
		
		for (int i = 0; i < N; ++i) {
			String name = br.readLine();
			
			keyByInteger.put(i + 1, name);
			keyByString.put(name, i + 1);
		}
		
		for (int i = 0; i < M; ++i) {
			String key = br.readLine();
			
			if (key.charAt(0) >= 'A') {
				sb.append(keyByString.get(key) + "\n");
			} else {
				sb.append(keyByInteger.get(Integer.parseInt(key)) + "\n");
			}
		}
		
		System.out.print(sb);
	}
}
