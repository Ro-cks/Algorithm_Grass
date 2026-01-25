import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        input();

        solution();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        for (int i = 1; i <= N; ++i) {
            arr[i] = Long.parseLong(br.readLine().trim());
        }

        tree = new long[4 * N];
    }

    static void solution() throws IOException {
        init(1, N, 1);

        for (int i = 0; i < M + K; ++i) {
            st = new StringTokenizer(br.readLine().trim());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, diff);
            } else {
                sb.append(sum(1, N, 1, b, (int) c)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) {

            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {

            return 0;
        }

        if (left <= start && end <= right) {

            return tree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || idx > end) {

            return;
        }

        tree[node] += diff;
        if (start == end) {

            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }
}
