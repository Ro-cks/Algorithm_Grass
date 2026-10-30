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

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; ++j) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floyd();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(dist[from][to]).append('\n');
        }

        System.out.print(sb.toString());
    }

    private static void floyd() {
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}