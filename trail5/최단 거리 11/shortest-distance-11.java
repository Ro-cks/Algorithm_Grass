import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) { this.to = to; this.cost = cost; }
    }

    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static long[] dist;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dijkstra(B);   // dist[v] = v에서 B까지 최단 거리

        StringBuilder sb = new StringBuilder();
        sb.append(dist[A]).append('\n');

        int cur = A;
        sb.append(cur);
        while (cur != B) {
            int nextV = Integer.MAX_VALUE;
            for (Edge e : graph[cur]) {
                if (dist[e.to] != INF && dist[cur] == e.cost + dist[e.to]) {
                    nextV = Math.min(nextV, e.to);   // 최단 경로 위의 이웃 중 가장 작은 번호
                }
            }
            cur = nextV;
            sb.append(' ').append(cur);
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int v = (int) curr[0];
            long d = curr[1];
            if (d > dist[v]) continue;

            for (Edge e : graph[v]) {
                long nd = d + e.cost;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{e.to, nd});
                }
            }
        }
    }
}