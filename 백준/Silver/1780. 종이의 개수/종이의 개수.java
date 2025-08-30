import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] nums;
	
	static int[] counts;
	
	public static void main(String[] args) throws IOException {
		init();
		
		cut(0, 0, N);
		
		for (int i = 0; i < 3; ++i) {
			System.out.println(counts[i]);
		}
	}
	
	static void cut(int r, int c, int size) {
		int num = nums[r][c];
		if (size == 1) {
			++counts[num + 1];
			
			return;
		}
		
		boolean isSame = true;
		
		for (int i = r; i < r + size; ++i) {
			for (int j = c; j < c + size; ++j) {
				if (num != nums[i][j]) {
					isSame = false;
				}
			}
		}
		
		if (isSame) {
			++counts[num + 1];
			
			return;
		} else {
			int newSize = size / 3;
			
			cut(r, c, newSize);
			cut(r, c + newSize, newSize);
			cut(r, c + 2 * newSize, newSize);
			cut(r + newSize, c, newSize);
			cut(r + newSize, c + newSize, newSize);
			cut(r + newSize, c + 2 * newSize, newSize);
			cut(r + 2 * newSize, c, newSize);
			cut(r + 2 * newSize, c + newSize, newSize);
			cut(r + 2 * newSize, c + 2 * newSize, newSize);
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		counts = new int[3];
		nums = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; ++j) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
