import java.io.*;
import java.util.*;

public class Main { // https://www.acmicpc.net/problem/11659
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N + 1];
		int[] prefix = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
			prefix[i] = prefix[i - 1] + nums[i];
		}
		
		for (int i = 0; i < M; ++i) {
			System.out.println(addArea(prefix));
		}
	}
	
	public static int addArea(int[] prefix) throws IOException {
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		return prefix[end] - prefix[start - 1];
	}
}
