import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int Q;
	static Set<Integer>[] set;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		set = new HashSet[N + 1];
		for (int i = 0; i <= N; ++i) {
			set[i] = new HashSet<>();
		}
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int setSize = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < setSize; ++j) {
				set[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < Q; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 2) {
				int setNum = Integer.parseInt(st.nextToken());
				sb.append(set[setNum].size()).append('\n');
			} else {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (set[b].size() > set[a].size()) {
					Set<Integer> temp = set[a];
					set[a] = set[b];
					set[b] = temp;
				}
				
				set[a].addAll(set[b]);
				
				set[b].clear();
			}
		}
		
		System.out.print(sb);
	}
}
