import java.io.*;
import java.util.*;
import java.util.function.IntFunction;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] D;
    static List<Node>[] graph;

    static final int INF = 250_000_000;

    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {

            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        D = new int[N + 1];
        Arrays.fill(D, INF);
        D[1] = 0;

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine().trim());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }
    }

    static void solution() {
        dijkstra();

        System.out.print(D[N]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            for (Node next : graph[curr.num]) {
                // D[curr.num]: 출발 노드부터 현재 노드까지 오는 최소 비용
                // next.cost: 현재 노드에서 다음 노드로 가는 간선 가중치
                if (D[next.num] > D[curr.num] + next.cost) {
                    D[next.num] = D[curr.num] + next.cost;

                    pq.offer(next);
                }
            }
        }
    }
}
