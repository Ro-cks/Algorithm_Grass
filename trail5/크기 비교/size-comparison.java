import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dist[A][B] = 1;
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            int count = 0;

            for (int j = 1; j <= N; ++j) {
                if (i == j) continue;

                if (dist[i][j] == 0 && dist[j][i] == 0) ++count;
            }
            sb.append(count).append('\n');
        }

        System.out.print(sb.toString());
    }

    private static void floyd() {
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
    }
}