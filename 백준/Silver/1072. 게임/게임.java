import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long X;
	static long Y;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		X = Long.parseLong(st.nextToken());
		Y = Long.parseLong(st.nextToken());
		
		answer = -1;
	}
	
	static void solution() {
		long Z = calZ(X, Y);
		if (Z == 99) {
			System.out.print(-1);
			
			return;
		}
		
		int st = 1;
		int en = 1000000000;
		boolean isChange = false;
		
		while (st <= en) {
			int mid = (st + en) / 2;
			long nX = X + mid;
			long nY = Y + mid;
			long nZ = calZ(nX, nY);
			
			// 승률에 변화가 없으면
			if (nZ <= Z) {
				st = mid + 1;
			} else { // 변했으면
				en = mid - 1;
				answer = mid;
			}
		}
		
		System.out.print(answer);
	}
	
	static long calZ(long nX, long nY) {
		
		return (nY * 100) / nX;
	}
}
