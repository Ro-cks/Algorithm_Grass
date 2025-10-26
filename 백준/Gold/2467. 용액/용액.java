import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		int answerL = 0;
		int answerR = 0;
		int minSum = 2000000001;
		int L = 0;
		int R = N - 1;
		
		while (L < R) {
			int sum = nums[L] + nums[R];
			
			if (Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				answerL = nums[L];
				answerR = nums[R];
			}
			
			if (sum < 0) {
				++L;
			} else if (sum > 0) {
				--R;
			} else {
				break;
			}
		}
		
		System.out.print(answerL + " " + answerR);
	}
}
