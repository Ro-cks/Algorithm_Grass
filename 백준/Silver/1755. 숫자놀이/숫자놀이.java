import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int M;
	static int N;
	static List<Num> nums;
	static String[] eng;
	
	static class Num implements Comparable<Num> {
		int num;
		String eng;
		
		public Num(int num, String eng) {
			this.num = num;
			this.eng = eng;
		}
		
		@Override
		public int compareTo(Num n) {
			
			return this.eng.compareTo(n.eng);
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		nums = new ArrayList<>();
		eng = new String[10];
		eng[0] = "zero";
		eng[1] = "one";
		eng[2] = "two";
		eng[3] = "three";
		eng[4] = "four";
		eng[5] = "five";
		eng[6] = "six";
		eng[7] = "seven";
		eng[8] = "eight";
		eng[9] = "nine";
	}
	
	static void solution() {
		for (int i = M; i <= N; ++i) {
			String iToString = String.valueOf(i);
			StringBuilder num = new StringBuilder();
			
			for (int j = 0; j < iToString.length(); ++j) {
				num.append(eng[iToString.charAt(j) - '0']);
			}
			
			nums.add(new Num(i, num.toString()));
		}
		
		Collections.sort(nums);
		
		int count = 0;
		for (int i = 0; i < nums.size(); ++i) {
			sb.append(nums.get(i).num).append(' ');
			
			++count;
			if (count == 10) {
				sb.append('\n');
				count = 0;
			}
		}
		
		System.out.print(sb);
	}
}
