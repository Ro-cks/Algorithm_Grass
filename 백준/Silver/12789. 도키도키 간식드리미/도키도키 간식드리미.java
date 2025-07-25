import java.io.*;
import java.util.*;

public class Main { 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException { 
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] tmp = new int[N];
		for (int i = 0; i < N; ++i) {
			tmp[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> line = new Stack<>();
		for (int i = N - 1; i >= 0; --i) {
			line.push(tmp[i]);
		}
		
		Stack<Integer> space = new Stack<>();
		
		boolean isSad = false;
		int index = 1;
		while (index <= N) { 
			if (line.isEmpty()) {
				break;
			}
			
			if (line.peek() == index) { 
				line.pop();
				++index;
			} else {
				if (space.isEmpty()) {
					space.push(line.pop());
				} else {
					if (space.peek() == index) {
						space.pop();
						++index;
					} else if (space.peek() > line.peek()) {
						space.push(line.pop());
					} else {
						isSad = true;
						
						break;
					}
				}
			}
		}

		if (isSad) {
			System.out.print("Sad");
		} else {
			System.out.print("Nice");
		}
	}
}
