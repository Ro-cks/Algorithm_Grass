import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> deck = new LinkedList<>();
		
		for (int i = 1; i <= N; ++i) {
			deck.add(i);
		}
		
		shuffle(deck, N);
		
		System.out.println(deck.peek());
	}
	
	public static void shuffle(Queue<Integer> deck, int N) {
		while (deck.size() != 1) {
			deck.remove();
			if (deck.size() == 1) {
				
				break;
			} else {
				deck.add(deck.poll());
			}
		}
	}
}
