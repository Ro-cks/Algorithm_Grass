import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;
    static int[][] D;

    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {

            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        D = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(D[i], 100_000_000);
            D[i][i] = 0;
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            if (b == 0) {
                D[u][v] = 0;
                D[v][u] = 1;
            } else {
                D[u][v] = 0;
                D[v][u] = 0;
            }
        }

        K = Integer.parseInt(br.readLine().trim());
    }

    static void solution() throws IOException {
        fw();

        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine().trim());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            sb.append(D[s][e]).append('\n');
        }

        System.out.print(sb);
    }

    static void fw() {
        for (int k = 0; k < N; ++k) {
            for (int s = 0; s < N; ++s) {
                for (int e = 0; e < N; ++e) {
                    if (D[s][e] > D[s][k] + D[k][e]) {
                        D[s][e] = D[s][k] + D[k][e];
                    }
                }
            }
        }
    }
}
