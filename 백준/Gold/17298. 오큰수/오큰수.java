import java.io.*;
import java.util.*;

public class Main { // www.acmicpc.net/problems/17298/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] NGE = new int[N];
		Deque<int[]> stack = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int value = Integer.parseInt(st.nextToken());
			
			if (stack.isEmpty()) {
				int[] arr = new int[2];
				arr[0] = i;
				arr[1] = value;
				
				stack.push(arr);
			} else {
				while (!stack.isEmpty() && stack.peek()[1] < value) {
					NGE[stack.peek()[0]] = value;
					stack.pop();
				}
				
				int[] arr = new int[2];
				arr[0] = i;
				arr[1] = value;
				
				stack.push(arr);
			}
		}
		
		for (int i = 0; i < N; ++i) {
			if (NGE[i] == 0) {
				sb.append(-1).append(' ');
			} else {
				sb.append(NGE[i]).append(' ');
			}
		}
		
		System.out.print(sb);
	}
}
