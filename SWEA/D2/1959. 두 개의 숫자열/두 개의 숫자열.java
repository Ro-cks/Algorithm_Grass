import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; ++test_case) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; ++i) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] shortArr;
            int[] longArr;

            if (N > M) {
                shortArr = B;
                longArr = A;
            } else {
                shortArr = A;
                longArr = B;
            }
            
            int answer = Integer.MIN_VALUE;
            
            for (int i = 0; i < longArr.length - shortArr.length + 1; ++i) {
                int currentSum = 0;
                
                for (int j = 0; j < shortArr.length; ++j) {
                    currentSum += shortArr[j] * longArr[i + j];
                }
                
                if (currentSum > answer) {
                    answer = currentSum;
                }
            }
            
            bw.write("#" + test_case + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
	}
}