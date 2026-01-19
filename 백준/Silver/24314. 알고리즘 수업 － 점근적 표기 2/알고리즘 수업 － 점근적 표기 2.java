import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int a1;
	static int a0;
	static int c;
	static int n0;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		a1 = Integer.parseInt(st.nextToken());
		a0 = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(br.readLine().trim());
		n0 = Integer.parseInt(br.readLine().trim());
	}
	
	static void solution() {
		if (f(n0) >= c * n0 && a1 >= c) {
			System.out.print(1);
		} else {
			System.out.println(0);
		}
	}
	
	static int f(int n) {

		return a1 * n + a0;
	}
}
