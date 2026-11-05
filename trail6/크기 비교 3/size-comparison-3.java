import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static List<Integer>[] graph;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) graph[i] = new ArrayList<>();

        pq = new PriorityQueue<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ++indegree[b];
            graph[a].add(b);
        }

        System.out.print(tpSort());
    }

    private static String tpSort() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; ++i) {
            if (indegree[i] == 0) pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(' ');

            for (int next : graph[curr]) {
                if (--indegree[next] == 0) pq.offer(next);
            }
        }

        return sb.toString();
    }
}