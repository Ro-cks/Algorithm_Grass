import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; ++i) parent[i] = i;

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int answer = 1;
        st = new StringTokenizer(br.readLine());
        int curr = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k - 1; ++i) {
            int next = Integer.parseInt(st.nextToken());

            if (find(curr) == find(next)) {
                curr = next;
            } else {
                answer = 0;
                break;
            }
        }

        System.out.print(answer);
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