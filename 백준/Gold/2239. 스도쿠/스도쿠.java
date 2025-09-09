import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		map = new int[9][9];
		
		for (int i = 0; i < 9; ++i) {
			String input = br.readLine().trim();
			
			for (int j = 0; j < 9; ++j) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static void solution() {
		DFS(0);
	}
	
	static void DFS(int depth) {
		if (depth == 81) {
			print();
			
			System.exit(0);
		}
		
		int r = depth / 9;
		int c = depth % 9;
		
		if (map[r][c] != 0) {
			DFS(depth + 1);
			
			return;
		}
		
		for (int num = 1; num <= 9; ++num) {
			if (isValid(r, c, num)) {
				map[r][c] = num;
				DFS(depth + 1);
				map[r][c] = 0;
			}
		}
	}
	
	static boolean isValid(int r, int c, int num) {
		
		
		return checkRow(r, num) && checkCol(c, num) && checkArea(r, c, num);
	}
	
	static boolean checkRow(int r, int num) {
		for (int c = 0; c < 9; ++c) {
			if (map[r][c] == num) {
				
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkCol(int c, int num) {
		for (int r = 0; r < 9; ++r) {
			if (map[r][c] == num) {
				
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkArea(int r, int c, int num) {
		int sr = (r / 3) * 3;
		int sc = (c / 3) * 3;
		
		for (int i = sr; i < sr + 3; ++i) {
			for (int j = sc; j < sc + 3; ++j) {
				if (map[i][j] == num) {
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void print() {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				sb.append(map[i][j]);
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
