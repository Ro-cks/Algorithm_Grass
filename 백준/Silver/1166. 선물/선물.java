import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long N, L, W, H;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Long.parseLong(st.nextToken());
		L = Long.parseLong(st.nextToken());
		W = Long.parseLong(st.nextToken());
		H = Long.parseLong(st.nextToken());
	}
	
	static void solution() {
		double st = 0;
		double en = 1000000000;
		
		for (int i = 0; i < 100; ++i) {
			double mid = (st + en) / 2;
			
			if (mid == 0) break;
			
			long count = (long)(L / mid) * (long)(H / mid) * (long)(W / mid);
			
			if (count >= N) {
				st = mid;
			} else {
				en = mid;
			}
		}
		
		System.out.print(st);
	}
}
