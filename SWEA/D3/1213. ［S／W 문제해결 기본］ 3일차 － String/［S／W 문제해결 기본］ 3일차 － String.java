import java.io.*;
import java.util.*;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int T;
	static String findingString;
	static String targetString;
	static String[] splitArr;
	static int cnt;
	static int idx;
	
	public static void main(String[] args) throws Exception {
		
		for (int test_case = 1; test_case <= 10; ++test_case) {
			T = Integer.parseInt(br.readLine());
			findingString = br.readLine();
			targetString = br.readLine();
			
			cnt = 0;
			idx = 0;
			while ((idx = targetString.indexOf(findingString, idx)) != -1) {
				++cnt;
				idx += findingString.length();
			}
			
			bw.write("#" + T + " " + cnt);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
