// 1. 1과 자기자신 외에 나누어 떨어지는 수가 있으면 --N
// 2. 

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] nums = new int[N];
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int num : nums) {
            if (num == 1) {
                --N;
                
                continue;
            }
            
            for (int i = 2; i < num; ++i) {
                if (num % i == 0) {
                    --N;
                    
                    break;
                }
            }
        }
        
        System.out.println(N);
    }
}