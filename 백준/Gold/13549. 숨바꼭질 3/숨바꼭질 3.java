import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static int[] D;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		D = new int[100001];
		Arrays.fill(D, 100001);
		D[N] = 0;
	}
	
	static void solution() {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(N);
		
		while (!dq.isEmpty()) {
			int curr = dq.poll();
			
			if (curr == K) {
				
				break;
			}
			
			if (curr - 1 >= 0) {
				if (D[curr - 1] > D[curr] + 1) {
					D[curr - 1] = D[curr] + 1;
					dq.addLast(curr - 1);
				}
			}
			
			if (curr + 1 <= 100000) {
				if (D[curr + 1] > D[curr] + 1) {
					D[curr + 1] = D[curr] + 1;
					dq.addLast(curr + 1);
				}
			}
			
			if (curr * 2 <= 100000) {
				if (D[curr * 2] > D[curr]) {
					D[curr * 2] = D[curr];
					dq.addFirst(curr * 2);
				}
			}
		}
		
		System.out.print(D[K]);
	}
}
