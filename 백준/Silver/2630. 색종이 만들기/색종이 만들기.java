import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[] answer;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		init();
		
		cut(0, 0, N);
		
		sb.append(answer[0]).append('\n');
		sb.append(answer[1]);
		
		System.out.print(sb);
	}
	
	static void cut(int r, int c, int size) {
		int num = map[r][c];
		
		if (size == 1) {
			++answer[num];
			
			return;
		}
		
		boolean isSame = true;
		for (int i = r; i < r + size; ++i) {
			for (int j = c; j < c + size; ++j) {
				if (map[i][j] != num) {
					isSame = false;
				}
			}
		}
		
		if (isSame) {
			++answer[num];
		} else {
			int newSize = size / 2;
			// topLeft
			cut(r, c, newSize);
			// topRight
			cut(r, c + newSize, newSize);
			// bottomLeft
			cut(r + newSize, c, newSize);
			// bottomRight
			cut(r + newSize, c + newSize, newSize);
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		answer = new int[2];
		map = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}