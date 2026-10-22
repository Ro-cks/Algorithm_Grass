import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int r = 0;
        int c = 0;
        int d = 0;
        int num = 1;
        int[][] nums = new int[N][M];
        while (num <= N * M) {
            nums[r][c] = num++;

            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!inRange(N, M, nr, nc) || nums[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                sb.append(nums[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static boolean inRange(int N, int M, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}