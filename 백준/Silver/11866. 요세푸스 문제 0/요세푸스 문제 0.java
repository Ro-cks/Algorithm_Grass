import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] men = new int[N];
		for (int i = 0; i < N; ++i) {
			men[i] = i + 1;
		}
		// K만큼 이동 후 0이 아닌 값일 때까지 한 칸씩 이동
		/* 1 2 3 4 5 6 7
		 * 1 2 0 4 5 6 7
		 * 1 2 0 4 5 0 7
		 * 1 0 0 4 5 0 7
		 * 1 0 0 4 5 0 0
		 * 
		 * */
		int index = -1;
		List<Integer> answer = new ArrayList<>();
		while (answer.size() != N) {			
			int count = 0;
			while (count != K) {
				index = (index + 1) % N;
				if (men[index] == 0) {
					continue;
				} else {
					++count;
				}
			}
//			
//			if (men[index] == 0) {
//				for (int i = 0; i < K; ++i) {		// K칸 이동, 0은 뛰어넘기
//					while (men[index] == 0) {
//						index = (index + 1) % N;
//					}
//				}
//			}		
			
			answer.add(men[index]);
			men[index] = 0;
			if (answer.size() == N) {
				break;
			}
		}
		
		sb.append('<');
		for (int i = 0; i < N - 1; ++i) {
			sb.append(answer.get(i)).append(',').append(' ');
		}
		sb.append(answer.get(answer.size() - 1)).append('>');
		
		System.out.print(sb);
	}
}
