// 0. (0, 0)부터 시작, 행과 열에 대해 +7칸이 배열을 벗어나지 않도록
// 1. 첫번째 칸의 색깔이 기준
// 2. 앞 칸의 색과 다음 칸을 비교
// 3. 같으면 다음 칸을 변경, 변경 횟수 +1
// 4. 기존의 변경 횟수보다 적으면 변경

import java.util.*;
import java.io.*;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        
        for (int i = 0; i < N; ++i) {
            
            String color = br.readLine();
            
            for (int j = 0; j < M; ++j) {
                board[i][j] = color.charAt(j);
            }
        }
        
        System.out.println(calMin(board, N, M));
    }
    
    public static int calMin(char[][] board, int N, int M) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int countW = 0; // W로 시작하는 경우
                int countB = 0; // B로 시작하는 경우

                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        char current = board[i + x][j + y];
                        // (x+y) 합이 짝수이면 시작 색과 같아야 함
                        if ((x + y) % 2 == 0) {
                            if (current != 'W') countW++;
                            if (current != 'B') countB++;
                        } else {
                            if (current != 'B') countW++;
                            if (current != 'W') countB++;
                        }
                    }
                }

                min = Math.min(min, Math.min(countW, countB));
            }
        }

        return min;
    }
}