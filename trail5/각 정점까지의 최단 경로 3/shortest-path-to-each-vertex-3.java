import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
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

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[num].add(new Edge(to, cost));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; ++i) {
            sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]).append('\n');
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });

        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int v = curr.to;
            int d = curr.cost;

            if (d > dist[v]) continue;

            for (Edge next : graph[v]) {
                int nd = dist[v] + next.cost; // 출발점에서 현재까지의 거리 + 현재에서 다음 정점으로 가는 거리
                if (nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.offer(new Edge(next.to, nd));
                }
            }
        }
    }
}