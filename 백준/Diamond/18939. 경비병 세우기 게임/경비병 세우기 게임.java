import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int M;
	static int K;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; ++t) {
			init();
			
			solution();
		}
		
		System.out.print(sb);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		if (M < 2 * K) {
			sb.append("Yuto");
		} else {
			if (N * M % 2 == 0) {
				sb.append("Platina");
			} else {
				sb.append("Yuto");
			}
		}
        sb.append('\n');
	}
}
