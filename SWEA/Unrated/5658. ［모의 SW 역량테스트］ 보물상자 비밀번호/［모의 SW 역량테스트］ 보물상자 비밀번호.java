import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int N;
	static int K;
	static long answer;
	static char[] nums;
	static Set<String> set;
	static List<Long> decs;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		for (int i = 0; i < N / 4; ++i) {
			// 수 저장
			save();
			
			// 회전
			rotate();
		}
		
		cal();
		
		answer = decs.get(K - 1);
	}
	
	static void save() {
		int count = 0;
		int max = N / 4;
		
		char[] num = new char[max];
		for (int i = 0; i < N; ++i) {
			num[count++] = nums[i];
			
			if (count == max) {
				set.add(new String(num));
				
				count = 0;
			}
		}
	}
	
	static void rotate() {
		char tmp = nums[N - 1];
		
		for (int i = N - 1; i >= 1; --i) {
			nums[i] = nums[i - 1];
		}
		
		nums[0] = tmp;
	}
	
	static void cal() {
		// TODO: 환산
		for (String str : set) {
			decs.add(Long.parseLong(str, 16));
		}
		
		Collections.sort(decs);
		Collections.reverse(decs);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nums = new char[N];
		
		set = new HashSet<>();
		decs = new ArrayList<>();
		
		String input = br.readLine().trim();
		for (int i = 0; i < N; ++i) {
			nums[i] = input.charAt(i);
		}
	}
}
