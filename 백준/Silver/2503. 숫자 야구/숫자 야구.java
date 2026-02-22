import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] conditions;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		conditions = new int[N][3];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			conditions[i][0] = Integer.parseInt(st.nextToken());
			conditions[i][1] = Integer.parseInt(st.nextToken());
			conditions[i][2] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void solution() {
		int answer = 0;
		
		for (int i = 123; i <= 987; ++i) {
			String candidate = String.valueOf(i);
			
			if (candidate.charAt(0) == candidate.charAt(1) ||
				candidate.charAt(1) == candidate.charAt(2) ||
				candidate.charAt(0) == candidate.charAt(2) ||
				candidate.contains("0")) {
				
				continue;
			}
			
			boolean isValid = true;
			
			for (int j = 0; j < N; ++j) {
				String guess = String.valueOf(conditions[j][0]);
				int tmpStrike = conditions[j][1];
				int tmpBall = conditions[j][2];
				
				int strike = 0;
				int ball = 0;
				
				for (int k = 0; k < 3; ++k) {
					for (int l = 0; l < 3; ++l) {
						if (candidate.charAt(k) == guess.charAt(l)) {
							if (k == l) {
								++strike;
							} else {
								++ball;
							}
						}
					}
				}
				
				if (strike != tmpStrike || ball != tmpBall) {
					isValid = false;
					
					break;
				}
			}
			
			if (isValid) {
				++answer;
			}
		}
		
		System.out.print(answer);
	}
}
