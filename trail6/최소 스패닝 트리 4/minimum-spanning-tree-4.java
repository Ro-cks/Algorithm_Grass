import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[] type;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; ++i) parent[i] = i;

        type = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) {
            char val = st.nextToken().charAt(0);

            type[i] = (val == 'a') ? 0 : 1;
        }

        edges = new int[M][3];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = cost;
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int total = 0;
        int count = 0;
        for (int[] edge : edges) {
            if (type[edge[0]] != type[edge[1]] && union(edge[0], edge[1])) {
                ++count;
                total += edge[2];
            }

            if (count == N - 1) break;
        }

        if (count == N - 1) System.out.print(total);
        else System.out.print(-1);
    }

    private static int find(int x) {
        if (parent[x] != x) return parent[x] = find(parent[x]);

        return parent[x];
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        parent[pb] = pa;

        return true;
    }
}