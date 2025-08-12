import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		initCity();
		destroy(0, new ArrayList<>());
		
		System.out.print(answer);
	}
	
	static void destroy(int start, List<int[]> selected) {
		if (selected.size() == M) {
			int sum = 0;
			for (int[] house : houses) {
				int minDist = Integer.MAX_VALUE;
				
				for (int[] chicken : selected) {
					int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
					minDist = Math.min(minDist, dist);
				}
				
				sum += minDist;
			}
			
			answer = Math.min(answer, sum);
			
			return;
		}
		
		for (int i = start; i < chickens.size(); ++i) {
			selected.add(chickens.get(i));
			destroy(i + 1, selected);
			selected.remove(selected.size() - 1);
		}
	}
	
	static void initCity() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; ++j) {
				int value = Integer.parseInt(st.nextToken());
				
				if (value == 1) {
					houses.add(new int[] {i, j});
				}
				
				if (value == 2) {
					chickens.add(new int[] {i, j});
				}
			}
		}
	}
}
