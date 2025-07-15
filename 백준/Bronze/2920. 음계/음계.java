// 1. 입력값을 차례대로 비교: 앞의 값과의 차이가 1보다 큰가?
// 2. 차이가 1보다 크면 mixed
// 3. 앞의 값보다 작다가 커지면 mixed
// 4. 계속 작아지면 descending
// 5. 계속 커지면 ascending

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pitches = new int[8];
        boolean isAsc = true;
        boolean isDes = true;
        
        for (int i = 0; i < 8; ++i) {
            pitches[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < 7; ++i) {
            if (pitches[i] > pitches[i + 1]) {
                isAsc = false;
            } else {
                isDes = false;
            }
        }
        
        if (isAsc) {
            System.out.println("ascending");
        } else if (isDes) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}