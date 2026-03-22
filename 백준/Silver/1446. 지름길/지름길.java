import java.io.*;
import java.util.*;
import java.util.function.IntFunction;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int D;
    static int[] dists;
    static List<Node>[] graph;

    static final int INF = 10000 * 10000;

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
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[10001];
        for (int i = 0; i <= 10000; ++i) {
            graph[i] = new ArrayList<>();

            if (i < 10000) {
                graph[i].add(new Node(i + 1, 1));
            }
        }

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (v <= D) {
                graph[u].add(new Node(v, cost));
            }
        }

        dists = new int[10001];
        Arrays.fill(dists, INF);
        dists[0] = 0;
    }

    static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.cost > dists[curr.num]) continue;

            for (Node next : graph[curr.num]) {
                if (dists[next.num] > dists[curr.num] + next.cost) {
                    dists[next.num] = dists[curr.num] + next.cost;
                    pq.add(new Node(next.num, dists[next.num]));
                }
            }
        }

        System.out.print(dists[D]);
    }
}
