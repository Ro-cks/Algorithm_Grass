// 1. 남는 사탕 0 => 남규 + 영훈 + 택희 == N
// 2. 남규 >= 영훈 + 2
// 3. 택희, 영훈, 남규 > 0
// 4. 택희 % 2 == 0

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                for (int k = 1; k <= N; ++k) {
                    if (i + j + k == N && i >= j + 2 && k % 2 == 0) {
                        ++answer;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }
}