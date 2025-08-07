import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			for (int j = N - i; j > 0; --j) {
				sb.append('*');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
