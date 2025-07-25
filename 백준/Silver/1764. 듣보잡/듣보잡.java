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
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			set.add(br.readLine());
		}
		
		List<String> names = new ArrayList<>();
		for (int i = 0; i < M; ++i) {
			String name = br.readLine();
			
			if (set.contains(name)) {
				names.add(name);
			}
		}
		
		Collections.sort(names);
		sb.append(names.size()).append('\n');
		for (int i = 0; i < names.size(); ++i) {
			sb.append(names.get(i)).append('\n');
		}
		
		System.out.print(sb);
	}
}
