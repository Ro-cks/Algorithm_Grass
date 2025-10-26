import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static PriorityQueue<Event> events;
	
	static class Event implements Comparable<Event> {
		int x;
		int type;
		
		public Event(int x, int type) {
			this.x = x;
			this.type = type;
		}
		
		public int compareTo(Event e) {
			if (this.x != e.x) {
				
				return this.x - e.x;
			}
			
			return this.type - e.type;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		events = new PriorityQueue<>();
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			events.add(new Event(x, 1));
			
			x = Integer.parseInt(st.nextToken());
			events.add(new Event(x, -1));
		}
	}
	
	static void solution() {
		int answer = 0;
		int curr = 0;
		
		while (!events.isEmpty()) {
			Event event = events.poll();
			
			curr += event.type;
			
			answer = Math.max(answer, curr);
		}
		
		System.out.print(answer);
	}
}
