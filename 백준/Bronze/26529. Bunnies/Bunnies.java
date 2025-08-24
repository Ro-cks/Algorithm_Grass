import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int x;
	static int[] fiboSeq = new int[47];
	
	public static void main(String[] args) throws IOException {
		fiboSeq[0] = 0;
		fiboSeq[1] = 1;
		for (int i = 2; i < fiboSeq.length; ++i) {
			fiboSeq[i] = fiboSeq[i - 1] + fiboSeq[i - 2];
		}
		
		n = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < n; ++i) {
			int x = Integer.parseInt(br.readLine().trim());
			sb.append(fiboSeq[x + 1]).append('\n');
		}
		
		System.out.print(sb);
	}
}
