import java.util.*;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		Iterator<Integer> iter = set.iterator();
		
		int[] answer = new int[set.size()];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = iter.next();
		}
		
		Arrays.sort(answer);
		
		for (int i = 0; i < answer.length; ++i) {
			sb.append(answer[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
