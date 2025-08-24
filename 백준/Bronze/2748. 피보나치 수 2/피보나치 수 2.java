import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int n;
	static long[] nums = new long[91];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine().trim());
		
		nums[0] = 0;
		nums[1] = 1;
		
		for (int i = 2; i < nums.length; ++i) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		
		System.out.print(nums[n]);
	}
}
