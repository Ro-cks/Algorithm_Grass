import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> nums = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; ++i) {
			if (nums.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
