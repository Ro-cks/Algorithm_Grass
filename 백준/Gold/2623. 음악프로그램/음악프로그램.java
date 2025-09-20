import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] D;
	static Queue<Integer> q;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws IOException{				
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; ++i) {
			graph[i] = new ArrayList<>();
		}
		
		D = new int[N + 1];
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int count = Integer.parseInt(st.nextToken());
			
			// 순서를 정할 가수가 1명 이하면 간선을 만들 필요가 없음
	        if (count <= 1) {
	            continue;
	        }

	        // 이전 가수를 저장해두고, 다음 가수가 나올 때마다 간선(prev -> curr)을 연결
	        int prev = Integer.parseInt(st.nextToken());
	        for (int j = 1; j < count; ++j) {
	            int curr = Integer.parseInt(st.nextToken());
	            graph[prev].add(curr);
	            ++D[curr]; // 현재 가수의 진입차수 증가
	            prev = curr; // 다음 반복을 위해 현재 가수를 이전 가수로 업데이트
	        }
		}
		
		q = new LinkedList<>();
		for(int i = 1; i <= N; ++i) {
			if(D[i] == 0) {
				q.offer(i);
			}
		}
	}
	
	static void solution() {
		topologySort();
		
		boolean flag = false;
		for(int i = 1; i <= N; ++i) {
			if(D[i] != 0) {
				flag = true;
				
				break;
			}
		}
		
		if (flag) {
			System.out.print(0);
		} else {
			System.out.print(sb);
		}
	}
	
	static void topologySort() {
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			sb.append(curr).append('\n');
			
			for(int next : graph[curr]) {
				--D[next];
				
				if(D[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}