import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int r = N - 1;
        int c = N - 1;
        int d = 0;
        int num = N * N;
        int nums[][] = new int[N][N];
        while (num >= 1) {
            nums[r][c] = num--;

            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!inRange(N, nr, nc) || nums[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            
            r = nr;
            c = nc;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(nums[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static boolean inRange(int N, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}