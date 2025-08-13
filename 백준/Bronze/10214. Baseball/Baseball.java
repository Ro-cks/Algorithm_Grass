import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		
		
		while(T-- > 0) {
			int Y = 0;
			int K = 0;
			
			for (int i = 0; i < 9; ++i) {
				st = new StringTokenizer(br.readLine());
				
				Y += Integer.parseInt(st.nextToken());
				K += Integer.parseInt(st.nextToken());
			}
			
			if (Y == K) {
				sb.append("Draw");
			} else if (Y > K) {
				sb.append("Yonsei");
			} else {
				sb.append("Korea");
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
