import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int cntOne;
	static int cntZero;
	static PriorityQueue<Integer> pos;
	static PriorityQueue<Integer> neg;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		cntOne = 0;
		cntZero = 0;
		pos = new PriorityQueue<>(Collections.reverseOrder());
		neg = new PriorityQueue<>();
		
		for (int i = 0; i < N; ++i) {
			int input = Integer.parseInt(br.readLine().trim());
			
			if (input == 1) {
				++cntOne;
			} else if (input == 0) {
				++cntZero;
			} else if (input > 0) {
				pos.add(input);
			} else {
				neg.add(input);
			}
		}
	}
	
	static void solution() {
		int sum = 0;
		
		while (pos.size() > 1) {
			int num1 = pos.poll();
			int num2 = pos.poll();
			
			sum = sum + num1 * num2;
		}
		
		if (!pos.isEmpty()) {
			sum += pos.poll();
		}
		
		while (neg.size() > 1) {
			int num1 = neg.poll();
			int num2 = neg.poll();
			
			sum = sum + num1 * num2;
		}
		
		if (!neg.isEmpty()) {
			if (cntZero == 0) {
				sum += neg.poll();
			}
		}
		
		sum += cntOne;
		
		System.out.print(sum);
	}
}
