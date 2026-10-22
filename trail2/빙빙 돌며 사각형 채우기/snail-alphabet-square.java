import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];

        int r = 0;
        int c = 0;
        int d = 0;
        int count = 0;
        while (count < N * M) {
            map[r][c] = (char) ('A' + count++ % 26);

            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!inRange(N, M, nr, nc) || map[nr][nc] != 0) {
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
                sb.append(map[i][j]).append(' ');
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static boolean inRange(int N, int M, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}