import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; ++j) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                dist[i][i] = 1;
            }
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    private static void floyd() {
        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
    }
}