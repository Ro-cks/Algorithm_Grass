import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        size = new int [N + 1];
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
            size[i] = 1;
        }

        int answer = 0;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!union(a, b)) ++answer;
        }

        int components = 0;
        for (int i = 1; i <= N; ++i) {
            if (find(i) == i) ++components;
        }
        answer += components - 1;

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

        if (size[pa] > size[pb]) {
            parent[pb] = pa;
            size[pa] += size[pb];
        } else {
            parent[pa] = pb;
            size[pb] += size[pa];
        }

        return true;
    }
}