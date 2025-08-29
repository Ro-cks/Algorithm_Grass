import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		init();
		
		System.out.print(solution(nums, 0, 0, nums.length));
	}
	
	static int solution(int[][] nums, int r, int c, int size) {
		if (size == 2) {
		    int[] fourValues = new int[4];
		    
		    fourValues[0] = nums[r][c];
		    fourValues[1] = nums[r][c+1];
		    fourValues[2] = nums[r+1][c];
		    fourValues[3] = nums[r+1][c+1];
		    
		    Arrays.sort(fourValues);
		    
		    return fourValues[2]; 
		}
		
		int half = size / 2;
		
		int topLeft = solution(nums, r, c, half);
		int topRight = solution(nums, r, c + half, half);
		int bottomLeft = solution(nums, r + half, c, half);
		int bottomRight = solution(nums, r + half, c + half, half);
		
		int[] answer = new int[4];
		answer[0] = topLeft;
		answer[1] = topRight;
		answer[2] = bottomLeft;
		answer[3] = bottomRight;
		
		Arrays.sort(answer);
		
		return answer[2];
		
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		nums = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			for (int j = 0; j < N; ++j) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
