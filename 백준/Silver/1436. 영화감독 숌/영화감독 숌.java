// 1. 6이 적어도 3개 연속
// 2. String으로 받아서 .contains
// 3. true면 N 감소
// 4. for문은 1000씩 증가하는 게 좋겠쥬?

import java.util.*;
import java.io.*;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(findNum(N));
    }
    
    public static int findNum(int N) {
        
        int answer = 0;
        
        for (int i = 666; i < Integer.MAX_VALUE; ++i) {
            if (String.valueOf(i).contains("666")) {
                --N;
            }
            
            if (N == 0) {
                answer = i;
                
                break;
            }
        }
        
        return answer;
    }
}