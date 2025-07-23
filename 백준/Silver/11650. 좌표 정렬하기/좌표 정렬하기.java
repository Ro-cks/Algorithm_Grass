import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		Integer[][] points = new Integer[N][2];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 2; ++j) {
				points[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(points, new Comparator<Integer[]>() {
			public int compare(Integer[] point1, Integer[] point2) {
				if (Integer.compare(point1[0], point2[0]) > 0) {
					
					return 1;
				} else if (Integer.compare(point1[0], point2[0]) == 0) {
					if (Integer.compare(point1[1], point2[1]) > 0) {
						
						return 1;
					} else {
						
						return -1;
					}
				} else {
					
					return -1;
				}
			}
		});
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < 2; ++j) {
				sb.append(points[i][j]).append(' ');
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
