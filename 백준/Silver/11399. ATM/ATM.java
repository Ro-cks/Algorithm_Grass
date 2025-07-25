import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/11399
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] times = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(times);
		
		int sum = 0;
		int preSum = 0;
		for (int i = 0; i < N; ++i) {
			preSum += times[i];
			sum += preSum;
		}
		
		System.out.print(sum);
	}
}
