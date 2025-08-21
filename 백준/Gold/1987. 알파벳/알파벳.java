import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans = 1;
    static char[][] board;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c, int mask, int depth) {
        ans = Math.max(ans, depth);

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k], nc = c + dc[k];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            int bit = 1 << (board[nr][nc] - 'A');
            if ((mask & bit) != 0) continue;        // 이미 사용한 알파벳

            dfs(nr, nc, mask | bit, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) board[i][j] = s.charAt(j);
        }

        int startMask = 1 << (board[0][0] - 'A');
        dfs(0, 0, startMask, 1);
        System.out.print(ans);
    }
}
