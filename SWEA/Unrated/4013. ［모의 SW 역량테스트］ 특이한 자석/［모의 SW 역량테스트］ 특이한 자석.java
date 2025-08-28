import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int K;
	static int answer;
	static int[] dists;
	static boolean[] isRotate;
	static List<Integer>[] magnetics;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int start = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			rotate(start, distance);
		}
		
		if (magnetics[1].get(0) == 1) answer += 1;
		if (magnetics[2].get(0) == 1) answer += 2;
		if (magnetics[3].get(0) == 1) answer += 4;
		if (magnetics[4].get(0) == 1) answer += 8;
	}
	
	static void rotate(int start, int distance) {
		dists = new int[5];
		isRotate = new boolean[5];
		isRotate[start] = true;
		dists[start] = distance;
		
		switch (start) {
			case 1:
				if (magnetics[start].get(2) != magnetics[2].get(6)) {
					isRotate[2] = true;
					dists[2] = -dists[start];
				}
				
				if (isRotate[2] && magnetics[2].get(2) != magnetics[3].get(6)) {
					isRotate[3] = true;
					dists[3] = -dists[2];
				}
				
				if (isRotate[3] && magnetics[3].get(2) != magnetics[4].get(6)) {
					isRotate[4] = true;
					dists[4] = -dists[3];
				}
				
				break;
			case 2:
				if (magnetics[start].get(6) != magnetics[1].get(2)) {
					isRotate[1] = true;
					dists[1] = -dists[start];
					//Collections.rotate(magnetics[1], -distance);
				}
				
				if (magnetics[start].get(2) != magnetics[3].get(6)) {
					isRotate[3] = true;
					dists[3] = -dists[start];
					//Collections.rotate(magnetics[3], -distance);
				}
				
				if (isRotate[3] && magnetics[3].get(2) != magnetics[4].get(6)) {
					isRotate[4] = true;
					dists[4] = -dists[3];
//					Collections.rotate(magnetics[4], distance);
				}
				
				break;
			case 3:
				if (magnetics[start].get(6) != magnetics[2].get(2)) {
					isRotate[2] = true;
					dists[2] = -dists[start];
//					Collections.rotate(magnetics[2], -distance);
				}
				
				if (isRotate[2] && magnetics[2].get(6) != magnetics[1].get(2)) {
					isRotate[1] = true;
					dists[1] = -dists[2];
//					Collections.rotate(magnetics[1], distance);
				}
				
				if (magnetics[start].get(2) != magnetics[4].get(6)) {
					isRotate[4] = true;
					dists[4] = -dists[start];
//					Collections.rotate(magnetics[4], -distance);
				}
				
				break;
			default:
				if (magnetics[start].get(6) != magnetics[3].get(2)) {
					isRotate[3] = true;
					dists[3] = -dists[start];
//					Collections.rotate(magnetics[3], -distance);
				}
				
				if (isRotate[3] && magnetics[3].get(6) != magnetics[2].get(2)) {
					isRotate[2] = true;
					dists[2] = -dists[3];
//					Collections.rotate(magnetics[2], distance);
				}
				
				if (isRotate[2] && magnetics[2].get(6) != magnetics[1].get(2)) {
					isRotate[1] = true;
					dists[1] = -dists[2];
//					Collections.rotate(magnetics[1], -distance);
				}
		}

		for (int i = 1; i < 5; ++i) {
			if (isRotate[i]) {
				Collections.rotate(magnetics[i], dists[i]);
			}
		}
	}
	
	static void init() throws IOException {
		K = Integer.parseInt(br.readLine().trim());
		answer = 0;
		
		magnetics = new ArrayList[5];
		for (int i = 1; i < 5; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			magnetics[i] = new ArrayList<>();
			for (int j = 0; j < 8; ++j) {
				magnetics[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}
}
