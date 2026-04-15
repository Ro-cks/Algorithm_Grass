import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static boolean[] visited;
    static int[][] W;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        visited = new boolean[N];
        W = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < N; ++j) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solution() {
        visited[0] = true;

        dfs(1, 0, 0);

        System.out.print(minCost);
    }

    static void dfs(int depth, int now, int cost) {
        if (depth >= N) {
            if (W[now][0] != 0) {
                minCost = Math.min(minCost, cost + W[now][0]);
            }

            return;
        }

        for (int i = 0; i < N; ++i) {
            if (!visited[i] && W[now][i] != 0) {
                visited[i] = true;
                dfs(depth + 1, i, cost + W[now][i]);
                visited[i] = false;
            }
        }
    }
}
