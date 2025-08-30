import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] counts;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		cut(0, 0, N);
		
		System.out.print(counts[0] + "\n" + counts[1]);
	}
	
	static void cut(int r, int c, int size) {
		int num = nums[r][c];
		if (size == 1) {
			++counts[num];
			
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
			++counts[num];
		} else {
			int newSize = size / 2;
			
			cut(r, c, newSize);
			cut(r + newSize, c, newSize);
			cut(r, c + newSize, newSize);
			cut(r + newSize, c + newSize, newSize);
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		counts = new int[2];
		nums = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
