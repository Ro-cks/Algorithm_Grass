import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/17219
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			map.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < M; ++i) {
			sb.append(map.get(br.readLine())).append('\n');
		}
		
		System.out.print(sb);
	}
}
