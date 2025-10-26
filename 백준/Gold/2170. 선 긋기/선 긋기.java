import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static List<Event> events;
	
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
		events = new ArrayList<>();
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			events.add(new Event(x, 0));
			
			x = Integer.parseInt(st.nextToken());
			events.add(new Event(x, 1));
		}
		
		Collections.sort(events);
	}
	
	static void solution() {
		int count = 0;
		int totalLength = 0;
		int startX = 0;
		
		for (Event e : events) {
			if (e.type == 0) {
				if (count == 0) {
					startX = e.x;
				}
				
				++count;
			} else {
				--count;
				if (count == 0) {
					totalLength += (e.x - startX);
				}
			}
		}
		
		System.out.print(totalLength);
	}
}
