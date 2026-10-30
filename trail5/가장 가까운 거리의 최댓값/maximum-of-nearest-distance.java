import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    static int N, M;
    static int A, B, C;
    static int[] distA;
    static int[] distB;
    static int[] distC;
    static List<Edge>[] graph;

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

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

        distA = new int[N + 1];
        distB = new int[N + 1];
        distC = new int[N + 1];
        Arrays.fill(distA, INF);
        Arrays.fill(distB, INF);
        Arrays.fill(distC, INF);
        distA[A] = 0;
        distB[B] = 0;
        distC[C] = 0;

        dijkstra(A, distA);
        dijkstra(B, distB);
        dijkstra(C, distC);

        int answer = 0;
        for (int i = 1; i <= N; ++i) {
            int nearest = Math.min(distA[i], Math.min(distB[i], distC[i]));
            if (nearest == INF) continue;
            answer = Math.max(answer, nearest);
        }

        System.out.print(answer);
    }

    private static void dijkstra(int X, int[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });

        pq.offer(new Edge(X, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (curr.cost > dist[curr.to]) continue;

            for (Edge next : graph[curr.to]) {
                if (dist[next.to] > next.cost + dist[curr.to]) {
                    dist[next.to] = next.cost + dist[curr.to];
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }
}