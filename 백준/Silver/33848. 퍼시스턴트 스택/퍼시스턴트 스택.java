import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static Stack<Integer> stack = new Stack<>();
	public static Stack<Integer> cmds = new Stack<>();
	public static Stack<Integer> values = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		int Q = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < Q; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			
			switch (cmd) {
				case 2:
					cmds.push(2);
					values.push(stack.pop());
					
					break;
				case 4:
					sb.append(stack.size()).append('\n');
					
					break;
				case 5:
					if (!stack.isEmpty()) {
						sb.append(stack.peek()).append('\n');
					} else {
						sb.append(-1).append('\n');
					}
					
					break;
				default:
					int value = Integer.parseInt(st.nextToken());
					proc(cmd, value);
			}
		}
		
		System.out.print(sb);
	}
	
	public static void proc(int cmd, int value) {
		switch (cmd) {
			case 1:
				stack.push(value);
				cmds.push(1);
				
				break;
			case 3:
				for (int j = 0; j < value; ++j) {
					switch (cmds.pop()) {
						case 1:
							stack.pop();
							break;
						case 2:
							stack.push(values.pop());
							break;
					}
				}
				
				break;
			default:
				
		}
	}
}
