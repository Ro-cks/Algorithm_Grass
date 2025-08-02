import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/23300
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static int curPage = -1;
	public static Deque<Integer> prePages = new ArrayDeque<>();
	public static Stack<Integer> proPages = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		surf();
		
		sb.append(curPage + "\n");
		
		if (prePages.isEmpty()) {
			sb.append(-1 + "\n");
		} else {
			while (!prePages.isEmpty()) {
				sb.append(prePages.pop() + " ");
			}
			sb.append('\n');
		}
		
		if (proPages.isEmpty()) {
			sb.append(-1 + "\n");
		} else {
			while (!proPages.isEmpty()) {
				sb.append(proPages.pop() + " ");
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void surf() throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < Q; ++i) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			switch (cmd) {
				case "B":
					if (prePages.isEmpty()) {
						continue;
					} else {
						proPages.push(curPage);
						curPage = prePages.pop();
					}
					break;
				case "F":
					if (proPages.isEmpty()) {
						continue;
					} else {
						prePages.push(curPage);
						curPage = proPages.pop();
					}
					break;
				case "A":
					proPages.clear();
					int accessPage = Integer.parseInt(st.nextToken());
					if (curPage == -1) {
						curPage = accessPage;
					} else {
						prePages.push(curPage);
						curPage = accessPage;
					}
					break;
				default:
					prePages.addLast(-1);
					while (prePages.peek() != -1) {
						int page = prePages.pop();
						while (prePages.peek() == page) {
							prePages.pop();
						}
						
						prePages.addLast(page);
					}
					
					prePages.pop();
			}
		}
	}
}
