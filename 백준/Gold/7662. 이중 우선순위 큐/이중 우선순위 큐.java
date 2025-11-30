import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int k;
	static TreeMap<Integer, Integer> treeMap;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; ++test_case) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		k = Integer.parseInt(br.readLine().trim());
		treeMap = new TreeMap<>();
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			char cmd = st.nextToken().charAt(0);
			int val = Integer.parseInt(st.nextToken());
			
			proc(cmd, val);
		}
		
		if (treeMap.isEmpty()) {
			sb.append("EMPTY");
		} else {
			sb.append(treeMap.lastKey()).append(' ').append(treeMap.firstKey());
		}
		
		sb.append('\n');
	}
	
	static void proc(char cmd, int val) {
		if (cmd == 'I') {
			treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
		} else {
			if (!treeMap.isEmpty()) {
				int targetKey;
				
				if (val == 1) {
					targetKey = treeMap.lastKey();
				} else {
					targetKey = treeMap.firstKey();
				}
				
				int count = treeMap.get(targetKey);
				
				if (count == 1) {
					treeMap.remove(targetKey);
				} else {
					treeMap.put(targetKey, count - 1);
				}
			}
		}
	}
}
