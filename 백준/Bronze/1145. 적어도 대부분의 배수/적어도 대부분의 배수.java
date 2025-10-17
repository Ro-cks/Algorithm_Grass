import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {	
		nums = new int[5];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < 5; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
//		int st = 1;
//		int en = 10000;
//		
//		while (st <= en) {
//			int mid = (st + en) / 2;
//			
//			int count = 0;
//			for (int i = 0; i < 5; ++i) {
//				if (mid % nums[i] == 0) {
//					++count;
//				}
//			}
//			
//			if (count >= 3) {
//				answer = mid;
//				en = mid - 1;
//			} else {
//				st = mid + 1;
//			}
//		}
//		
//		System.out.print(answer);
		
		answer = 1;
		while (true) {
			
			int count = 0;
			for (int i = 0; i < 5; ++i) {
				if (answer % nums[i] == 0) {
					++count;
				}
			}
			
			if (count >= 3) {
				
				break;
			}
			
			++answer;
		}
		
		System.out.print(answer);
	}
}
