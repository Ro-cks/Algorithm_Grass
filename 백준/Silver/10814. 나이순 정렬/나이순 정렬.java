import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		String[][] users = new String[N][3];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			users[i][0] = String.valueOf(i);
			
			for (int j = 1; j < 3; ++j) {
				users[i][j] = st.nextToken();
			}
		}
		
		Arrays.sort(users, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if (Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1])) > 0) {
					
					return 1;
				} else if (Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1])) == 0) {
					if (Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0])) > 0) {
						
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
			sb.append(users[i][1]).append(' ').append(users[i][2]).append('\n');
		}
		
		System.out.print(sb);
	}
}
