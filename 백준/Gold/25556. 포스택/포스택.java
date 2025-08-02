import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/25556
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	@SuppressWarnings("unchecked")
	public static Deque<Integer>[] stacks = new ArrayDeque[4];
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 4; ++i) {
			stacks[i] = new ArrayDeque<>();
		}
		
		if (proc()) {
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}
	}
	
	public static boolean proc() throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			boolean isProced = false;
			
			for (int j = 0; j < 4; ++j) {
				if (stacks[j].isEmpty()) {
					stacks[j].push(num);
					isProced = true;
					
					break;
				} else if (!stacks[j].isEmpty() && num > stacks[j].peek()) {
					stacks[j].push(num);
					isProced = true;
					
					break;
				}
			}
			
			if (!isProced) {
				
				return false;
			}
		}
		
		return true;
	}
}
