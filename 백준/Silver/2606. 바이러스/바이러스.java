import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problems/2606/
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static int N;
	public static int C;
	
	public static int count = 0;
	
	public static List<Integer>[] conn;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		conn = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 0; i <= N; ++i) {
			conn[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < C; ++i) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int conNum = Integer.parseInt(st.nextToken());
			
			conn[num].add(conNum);
			conn[conNum].add(num);
		}
		
		bfs(1);
		
		System.out.print(count - 1);
	}
	
	public static void bfs(int n) {
		if (visited[n]) {
			
			return;
		}
		
		visited[n] = true;
		++count;
		
		for (int i = 0; i < conn[n].size(); ++i) {
			bfs(conn[n].get(i));
		}
	}
}
