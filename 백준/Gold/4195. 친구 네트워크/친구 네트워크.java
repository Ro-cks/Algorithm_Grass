import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int F;
	static Map<String, String> sets;
	static Map<String, Integer> sizes;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < F; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			String a = st.nextToken();
			String b = st.nextToken();
			
			if (!sets.containsKey(a)) {
				sets.put(a, a);
				sizes.put(a, 1);
			}
			
			if (!sets.containsKey(b)) {
				sets.put(b, b);
				sizes.put(b, 1);
			}
			
			sb.append(union(a, b)).append('\n');
		}
	}
	
	static int union(String a, String b) {
		String parentA = find(a);
		String parentB = find(b);
		
		if (parentA.equals(parentB)) {
			
			return sizes.get(parentA);
		}
		
		sets.put(parentB, parentA);
		sizes.put(parentA, sizes.get(parentA) + sizes.get(parentB));
		
		return sizes.get(parentA);
	}
	
	static String find(String name) {
		if (sets.get(name).equals(name)) {
			
			return name;
		} 
		
		String root = find(sets.get(name));
		sets.put(name, root);
		
		return root;
	}
	
	static void init() throws IOException {
		F = Integer.parseInt(br.readLine().trim());
		sets = new HashMap<>();
		sizes = new HashMap<>();
	}
}
