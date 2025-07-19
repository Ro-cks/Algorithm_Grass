// 1. 근의 공식
// 2. 두 근은 항상 정수, 항상 짝수 공식에 대입 가능
// 3. 오름차순으로 출력
// 4. 중근일 경우 하나만 출력

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[] roots = new int[2];
        roots[0] = (int) (A * -1 + Math.sqrt(Math.pow(A, 2) - B));
        roots[1] = (int) (A * -1 - Math.sqrt(Math.pow(A, 2) - B));
        
        Arrays.sort(roots);
        
        if (Math.pow(A, 2) - B == 0) {
            System.out.println(roots[0]);
        } else {
            System.out.println(roots[0] + " " + roots[1]);
        }
    }
}