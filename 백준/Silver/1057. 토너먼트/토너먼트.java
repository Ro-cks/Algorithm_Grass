import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int kim;
	static int lim;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		kim = Integer.parseInt(st.nextToken());
		lim = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		int answer = 0;
		
		while (kim != lim) {
			kim = (kim + 1) / 2;
			lim = (lim + 1) / 2;
			
			++answer;
		}
		
		System.out.print(answer);
	}
}