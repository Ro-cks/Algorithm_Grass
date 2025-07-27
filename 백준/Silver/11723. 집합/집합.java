import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/11723
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static Set<Integer> set = new HashSet<>();
	public static Map<String, Integer> commands = new HashMap<String, Integer>() {{
		put("add", 0);
		put("remove", 1);
		put("check", 2);
		put("toggle", 3);
		put("all", 4);
		put("empty", 5);
	}};
	
	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			
			if (cmd.equals("all")) {
				for (int j = 1; j <= 20; ++j) {
					set.add(j);
				}
				
				continue;
			}
			
			if (cmd.equals("empty")) {
				set.clear();
				
				continue;
			}
			
			proc(cmd, Integer.parseInt(st.nextToken()));
		}
		
		System.out.print(sb);
	}
	
	public static void proc(String cmd, int value) {
		boolean isContain = set.contains(value);
		
		switch (commands.get(cmd)) {
			case 0:
				set.add(value);
				break;
			case 1:
				if (isContain) {
					set.remove(value);
				}
				break;
			case 2:
				if (isContain) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case 3:
				if (isContain) {
					set.remove(value);
				} else {
					set.add(value);
				}
				break;
			default:
				
		}
	}
}
