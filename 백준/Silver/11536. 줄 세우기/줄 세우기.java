import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static String[] names;
	
	static final String INC = "INCREASING";
	static final String DSC = "DECREASING";
	static final String NEI = "NEITHER";
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		names = new String[N];
		
		for (int i = 0; i < N; ++i) {
			String name = br.readLine().trim();
			names[i] = name;
		}
	}
	
	static void solution() {
		String[] inc = names.clone();
		String[] dsc = names.clone();
		
		Arrays.sort(inc);
		Arrays.sort(dsc, Comparator.reverseOrder());
		
		boolean answer = true;
		for (int i = 0; i < N; ++i) {
			if (!names[i].equals(inc[i])) {
				answer = false;
				
				break;
			}
		}
		
		if (answer) {
			System.out.print(INC);
			
			System.exit(0);
		}
		
		answer = true;
		for (int i = 0; i < N; ++i) {
			if (!names[i].equals(dsc[i])) {
				answer = false;
				
				break;
			}
		}
		
		if (answer) {
			System.out.print(DSC);
			
			System.exit(0);
		}
		
		System.out.print(NEI);
	}
}
