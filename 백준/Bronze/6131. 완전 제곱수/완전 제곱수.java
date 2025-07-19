// 1. A^2 = B^2 + N
// 2. A, B <= 500
// 3. A를 1부터 시작해서 제곱한다.
// 4. B도 1부터 시작해서 제곱한다음 N을 더한다.
// 5. 두 값을 비교해서 같으면 ++정답

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        for (int i = 1; i <= 500; ++i) {
            for (int j = 1; j <= 500; ++j) {
                if (Math.pow(i, 2) == Math.pow(j, 2) + N) {
                    ++answer;
                }
            }
        }
        
        System.out.println(answer);
    }
}