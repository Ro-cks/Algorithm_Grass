import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] cards;
	static int[] nums;
	static HashSet<Integer> set;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		set = new HashSet<>();
		
		N = Integer.parseInt(br.readLine().trim());
		cards = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			// cards[i] = Integer.parseInt(st.nextToken());
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		M = Integer.parseInt(br.readLine().trim());
		nums = new int[M];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < M; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		for (int i = 0; i < M; ++i) {
			if (set.contains(nums[i])) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append(' ');
		}
		
		System.out.print(sb);
	}
}
