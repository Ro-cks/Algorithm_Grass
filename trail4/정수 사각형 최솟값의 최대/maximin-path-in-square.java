import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = map[1][1];
        for (int i = 2; i <= N; ++i) {
            dp[i][1] = Math.min(dp[i - 1][1], map[i][1]);
            dp[1][i] = Math.min(dp[1][i - 1], map[1][i]);
        }

        for (int i = 2; i <= N; ++i) {
            for (int j = 2; j <= N; ++j) {
                dp[i][j] = Math.min(map[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        System.out.print(dp[N][N]);
    }
}