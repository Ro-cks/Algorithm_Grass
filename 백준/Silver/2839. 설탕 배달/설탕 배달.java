import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		answer = 0;
	}
	
	static void solution() {
		while (N >= 0) {
			if (N % 5 == 0) {
				answer += N / 5;
				
				break;
			}
			
			N -= 3;
			++answer;
		}
		
		answer = N < 0 ? -1 : answer;
		
		System.out.print(answer);
	}
}
