import java.util.*;
import java.io.*;

public class Solution {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; ++testCase) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] board = new int[N][N];
			
			for (int r = 0; r < N; ++r) {
				String price = br.readLine();
				
				for (int c = 0; c < N; ++c) {
					board[r][c] = price.charAt(c) - '0';
				}
			}
			
			int answer = calc(board);
			sb.append('#').append(testCase).append(' ').append(answer).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static int calc(int[][] board) {
		int answer = 0;
		int N = board.length;
		int mid = N / 2;
		
		for (int r = 0; r < N; ++r) { // N = 5, r: 0, 1, 2, 3, 4
			int range = mid - Math.abs(mid - r);
			
			for (int c = mid - range; c <= mid + range; ++c) {
				answer += board[r][c];
			}
		}

		return answer;
	}
}
