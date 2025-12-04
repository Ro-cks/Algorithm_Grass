import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] board;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[101];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			board[start] = end;
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			board[start] = end;
		}
	}
	
	static void solution() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0});
		
		int[] counts = new int[101];
		
		while (true) {
			int[] curr = q.poll();
			int index = curr[0];
			int count = curr[1];
			
			if (index == 100) {
				break;
			}
			
			for (int i = 1; i <= 6; ++i) {
				int next = index + i;
				
				if (next > 100) break;
				if (counts[next] != 0) continue;
				
				if (board[next] != 0) {
					counts[next] = count + 1;
					q.add(new int[] {board[next], count + 1});
					
					continue;
				}
				
				counts[next] = count + 1;
				q.add(new int[] {next, count + 1});
			}
		}
		
		System.out.print(counts[100]);
	}
}
