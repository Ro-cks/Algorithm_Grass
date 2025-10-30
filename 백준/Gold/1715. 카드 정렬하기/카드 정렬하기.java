import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; ++i) {
			int size = Integer.parseInt(br.readLine().trim());
			pq.add(size);
		}
	}
	
	static void solution() {
		int size1 = 0;
		int size2 = 0;
		int sum = 0;
		
		while (pq.size() != 1) {
			size1 = pq.poll();
			size2 = pq.poll();
			
			sum += size1 + size2;
			pq.add(size1 + size2);
		}
		
		System.out.print(sum);
	}
}
