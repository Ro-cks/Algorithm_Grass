import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int K;
	static List<Index> belt;
	
	static class Index {
		int durability;
		boolean isRobot;
		
		public Index(int durability) {
			this.durability = durability;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new ArrayList<>(2 * N);
		
		st = new StringTokenizer(br.readLine().trim());
		
		for (int i = 0; i < 2 * N; ++i) {
			int durability = Integer.parseInt(st.nextToken());
			belt.add(i, new Index(durability));
		}
	}
	
	static void solution() {
		int answer = simulator();
		
		System.out.print(answer);
	}
	
	static int simulator() {
		int turn = 0;
		
		while (true) {
			int count = 0;
			for (Index idx : belt) {
				if (idx.durability == 0) ++count;
			}
			
			if (count >= K) {
				
				break;
			}
			
			Collections.rotate(belt, 1);
			if (belt.get(N - 1).isRobot) {
				belt.get(N - 1).isRobot = false;
			}
			
			move();
			
			put();
			
			++turn;
		}
		
		return turn;
	}
	
	static void move() {
		for (int i = N - 2; i >= 0; --i) {
			Index index = belt.get(i);
			Index nextIndex = belt.get(i + 1);
			
			if (index.isRobot && !nextIndex.isRobot && nextIndex.durability != 0) {
				nextIndex.isRobot = true;
				--nextIndex.durability;
				if (i + 1 == N - 1) {
					nextIndex.isRobot = false;
				}
				
				index.isRobot = false;
			}
		}
	}
	
	static void put() {
		Index index = belt.get(0);
		
		if (index.durability != 0) {
			index.isRobot = true;
			--index.durability;
		}
	}
}
