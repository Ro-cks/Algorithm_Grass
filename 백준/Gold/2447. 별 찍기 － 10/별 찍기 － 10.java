import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution(0, 0, N);
		
		for (int i = 0; i < N; ++i) {
			sb.append(map[i]);
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution(int r, int c, int size) {
		if (size == 1) {
			map[r][c] = '*';
			
			return;
		}
		
		int newSize = size / 3;
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (i == 1 && j == 1) continue;
				
				solution(r + i * newSize, c + j * newSize, newSize);
			}
		}
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		map = new char[N][N];
		
		for (int i = 0; i < N; ++i) {
			Arrays.fill(map[i], ' ');
		}
	}
}
