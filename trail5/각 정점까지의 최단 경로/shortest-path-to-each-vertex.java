import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[] dist;
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
        K = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        Arrays.fill(dist, 200_000);
        dist[K] = 0;

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            sb.append(dist[i] == 200_000 ? -1 : dist[i]).append('\n');
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });

        pq.offer(new Edge(K, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int v = curr.to;
            int d = curr.cost;

            if (dist[v] < d) continue;

            for (Edge next : graph[v]) {
                int nd = dist[v] + next.cost;

                if (nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.offer(new Edge(next.to, nd));
                }
            }
        }
    }
}