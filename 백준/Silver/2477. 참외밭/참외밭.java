import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int K;
	static int maxWidth = 0;
	static int maxHeight = 0;
	static int maxWidthIndex = -1;
	static int maxHeightIndex = -1;
	static int smallRecWidth;
	static int smallRecHeight;
	static int area;
	static int answer;
	static int[] dirs = new int[5];
	static int[][] inputs = new int[6][2];
	
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		
		// 방향과 길이 입력받기, max/index 구하기
		for (int i = 0; i < 6; ++i) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			++dirs[direction];
			inputs[i][0] = direction;
			inputs[i][1] = distance;
			
			if (direction < 3) { // 동 서
				if (distance > maxWidth) {
					maxWidth = distance;
					maxWidthIndex = i;
				}
			} else { // 남 북
				if (distance > maxHeight) {
					maxHeight = distance;
					maxHeightIndex = i;
				}
			}
		}
		
		// 케이스 구분
		int shape = 0;
		if (dirs[1] == 2) {
			if (dirs[3] == 2) {
				shape = 1;
			} else {
				shape = 4;
			}
		} else {
			if (dirs[3] == 2) {
				shape = 2;
			} else {
				shape = 3;
			}
		}
		
		// 밭 모양에 따른 작은 사각형의 가로, 세로 구하기
		switch (shape) {
			case 1: // maxWidthIndex + 2, + 3이 가로, 세로
			case 3:
				smallRecWidth = inputs[(maxWidthIndex + 2) % 6][1];
				smallRecHeight = inputs[(maxWidthIndex + 3) % 6][1];
				break;
			default: // maxHeightIndex + 3, + 2이 가로, 세로
				smallRecWidth = inputs[(maxHeightIndex + 3) % 6][1];
				smallRecHeight = inputs[(maxHeightIndex + 2) % 6][1];
				break;
		}
		
		area = (maxWidth * maxHeight) - (smallRecWidth * smallRecHeight);
		answer = area * K;
		
		System.out.print(answer);
	}
}
