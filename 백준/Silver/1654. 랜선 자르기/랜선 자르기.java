import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int K;
	static int N;
	static long answer;
	static int[] length;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		length = new int[K];
		for (int i = 0; i < K; ++i) {
			length[i] = Integer.parseInt(br.readLine().trim());
		}
		
		answer = 0;
	}
	
	static void solution() {
		Arrays.sort(length);
		
		long st = 1;
		long en = length[K - 1];
		
		while (st <= en) {
			long count = 0;
			long mid = (st + en) / 2;
			
			for (int i = 0; i < K; ++i) {
				count += length[i] / mid;
			}
			
			if (count >= N) {
				answer = Math.max(answer, mid);
				st = mid + 1;
			} else {
				en = mid - 1;
			}
		}
		
		System.out.print(answer);
	}
}
