import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		cut(0, 0, N);
		
		System.out.print(sb);
	}
	
	static void cut(int r, int c, int size) {
		int num = nums[r][c];
		
		if (size == 1) {
			sb.append(num);
			return;
		} else {
			
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
			sb.append(num);
		} else {
			int ns = size / 2;
			
			sb.append('(');
			// top left
			cut(r, c, ns);
			// top right
			cut(r, c + ns, ns);
			// bottom left
			cut(r + ns, c, ns);
			// bottom right
			cut(r + ns, c + ns, ns);
			sb.append(')');
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < N; ++j) {
				nums[i][j] = input.charAt(j) - '0';
			}
		}
	}
}
