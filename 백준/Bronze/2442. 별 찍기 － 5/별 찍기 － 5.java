import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			for (int j = i; j < N - 1; ++j) {
				sb.append(' ');
			}
			
			for (int j = 0; j < i * 2 + 1; ++j) {
				sb.append('*');
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
/* 0 1 2 3 4
 * 1 3 5 7 9
 * i * 2 + 1
 */
