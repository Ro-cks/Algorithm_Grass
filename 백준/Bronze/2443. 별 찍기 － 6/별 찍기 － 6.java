import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < i; ++j) {
				sb.append(' ');
			}
			
			for (int j = 0; j < N * 2 - 1 - i * 2; ++j) {
				sb.append('*');
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
/* 0 1 2 3 4
 * 9 7 5 3 1
 * N * 2 - 1 - i * 2
 */
