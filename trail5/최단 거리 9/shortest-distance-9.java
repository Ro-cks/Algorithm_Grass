import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int A;
    static int B;
    static int[] dist;
    static int[] prev;
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
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        prev = new int[N + 1];
        Arrays.fill(prev, -1);

        dist = new int[N + 1];
        Arrays.fill(dist, 100_000_000);
        dist[A] = 0;

        dijkstra();

        StringBuilder sb = new StringBuilder();
        sb.append(dist[B]).append('\n');

        int x = B;
        List<Integer> path = new ArrayList<>();
        path.add(x);
        while (x != A) {
            x = prev[x];
            path.add(x);
        }

        for (int i = path.size() - 1; i >= 0; --i) {
            sb.append(path.get(i)).append(' ');
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });

        pq.offer(new Edge(A, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int v = curr.to;
            int d = curr.cost;

            if (d > dist[v]) continue;

            for (Edge next : graph[v]) {
                int nd = dist[v] + next.cost;

                if (nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.offer(new Edge(next.to, nd));
                    prev[next.to] = v;
                }
            }
        }
    }
}