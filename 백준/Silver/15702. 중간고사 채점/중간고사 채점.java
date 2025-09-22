import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] scores;
	static List<Candidate> cans;
	
	static class Candidate implements Comparable<Candidate> {
		int num;
		int score;
		
		public Candidate(int num, int score) {
			this.num = num;
			this.score = score;
		}
		
		@Override
		public int compareTo(Candidate c) {
			if (this.score == c.score) {
				
				return Integer.compare(this.num, c.num);
			}
			
			return Integer.compare(c.score, this.score);
		}
		
		@Override
		public String toString() {
			
			return num + " " + score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		scores = new int[N];
		cans = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() throws IOException {
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			int num = Integer.parseInt(st.nextToken());
			int score = grading(st);
			
			cans.add(new Candidate(num, score));
		}
		
		Collections.sort(cans);
		
		System.out.print(cans.get(0).toString());
	}
	
	static int grading(StringTokenizer st) {
		int score = 0;
		
		for (int i = 0; i < N; ++i) {
			String result = st.nextToken();
			
			if (result.equals("O")) {
				score += scores[i];
			}
		}
		
		return score;
	}
}
