import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] sets;
	
	static final String YES = "yes";
	static final String NO = "no";
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch (cmd) {
				case 0:
					union(a, b);
					break;
				default:
					if (find(a) == find(b)) sb.append(YES).append('\n');
					else sb.append(NO).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	static int find(int start) {
		if (sets[start] == start) {
			
			return start;
		}
		
		return sets[start] = find(sets[start]);
	}
	
	static void union(int a, int b) {
		int setA = find(a);
		int setB = find(b);
		
		int repreSet = setA <= setB ? setA : setB;
		
		sets[setB] = setA;
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sets = new int[N + 1];
		for (int i = 0; i <= N; ++i) {
			sets[i] = i;
		}
	}
}
