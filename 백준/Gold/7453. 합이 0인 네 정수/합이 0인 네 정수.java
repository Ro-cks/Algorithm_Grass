import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		
		nums = new int[N][4];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < 4; ++j) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void solution() {
		int[] sumA = new int[N * N];
		int[] sumB = new int[N * N];
		
		int index = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sumA[index++] = nums[i][0] + nums[j][1];
			}
		}
		
		index = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				sumB[index++] = nums[i][2] + nums[j][3];
			}
		}
		
		Arrays.sort(sumA);
		Arrays.sort(sumB);
		long answer = 0;
		int L = 0;
		int R = N * N - 1;
		int valA = 0;
		int valB = 0;
		long countA = 0;
		long countB = 0;
		
		while (L < N * N && R >= 0) {
			int sum = sumA[L] + sumB[R];
			if (sum < 0) {
				++L;
			} else if (sum > 0) {
				--R;
			} else {
				valA = sumA[L];
				valB = sumB[R];
				
				while (L < N * N && valA == sumA[L]) {
					++countA;
					++L;
				}
				while (R >= 0 && valB == sumB[R]) {
					++countB;
					--R;
				}
				
				answer += countA * countB;
				
				countA = 0;
				countB = 0;
			}
		}
		
		System.out.print(answer);
	}
}
