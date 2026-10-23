import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, K;
    static int[][] map;
    static int[][] cells;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cells = new int[N * N][];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cells[i * N + j] = new int[] {i, j};
            }
        }
        Arrays.sort(cells, (a, b) -> Integer.compare(map[b[0]][b[1]], map[a[0]][a[1]]));

        int lo = 1;
        int hi = 100_000_000;
        int answer = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canMake(mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean canMake(int D) {
        int[][] dp = new int[N][N];

        for (int[] cell : cells) {
            int r = cell[0];
            int c = cell[1];
            dp[r][c] = 1;

            for (int d = 0; d < 4; ++d) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!inRange(nr, nc)) continue;

                int diff = map[nr][nc] - map[r][c];
                if (diff <= 0 || diff > D) continue;
                dp[r][c] = Math.max(dp[r][c], dp[nr][nc] + 1);
            }

            if (dp[r][c] >= K) return true;
        }

        return false;
    }

    private static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}