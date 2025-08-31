import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int r;
	static int c;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution(0, (int) Math.pow(2, N), r, c);
		
		System.out.print(answer);
	}
	
	static void solution(int count, int size, int row, int col) {		
		if (size == 2) {
			answer = count;
			
			if (row == 0 && col == 1) {
				answer += 1;
			} else if (row == 1 && col == 0) {
				answer += 2;
			} else if (row == 1 && col == 1) {
				answer += 3;
			}
			
			return;
		}
		
		int mid = size / 2;
		
		if (row < mid && col < mid) {
			solution(count, mid, row, col);
		} else if (row < mid && col >= mid) {
			solution(count + mid * mid, mid, row, col - mid);
		} else if (row >= mid && col < mid) {
			solution(count + mid * mid * 2, mid, row - mid, col);
		} else if (row >= mid && col >= mid) {
			solution(count + mid * mid * 3, mid, row - mid, col - mid);
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		answer = 0;
	}
}
