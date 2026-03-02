import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final long INF = Long.MAX_VALUE / 2;

    static int N;
    static int M;
    static List<List<Edge>> graph;

    static class Node implements Comparable<Node> {
        int num;
        long distance;
        int state; // 0: 빠르게 도착한 상태, 1: 느리게 도착한 상태. 여우는 사용 X

        public Node(int num, long distance, int state) {
            this.num = num;
            this.distance = distance;
            this.state = state;
        }

        @Override
        public int compareTo(Node other) {

            return Long.compare(this.distance, other.distance);
        }
    }

    static class Edge {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
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

        graph = new ArrayList<>();
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }

        int a, b;
        long d;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()) * 2;

            graph.get(a).add(new Edge(b, d));
            graph.get(b).add(new Edge(a, d));
        }
    }

    static void solution() {
        int answer = 0;

        long[] foxD = new long[N + 1];
        Arrays.fill(foxD, INF);
        dijkstraFox(foxD);

        long[][] wolfD = new long[N + 1][2];
        for (int i = 0; i <= N; ++i) {
            Arrays.fill(wolfD[i], INF);
        }
        dijkstraWolf(wolfD);

        for (int i = 2; i <= N; ++i) {
            if (foxD[i] < Math.min(wolfD[i][0], wolfD[i][1])) {
                ++answer;
            }
        }

        System.out.print(answer);
    }

    static void dijkstraFox(long[] foxD) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0, 0));
        foxD[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int num = curr.num;
            long dist = curr.distance;

            if (foxD[num] < dist) continue;

            for (Edge edge : graph.get(num)) {
                long cost = dist + edge.weight;
                if (cost < foxD[edge.to]) {
                    foxD[edge.to] = cost;
                    pq.offer(new Node(edge.to, cost, 0));
                }
            }
        }
    }

    static void dijkstraWolf(long[][] wolfD) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 늑대는 처음 출발할 때 '빠르게' 가야 함.
        pq.offer(new Node(1, 0, 1));
        wolfD[1][1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int num = curr.num;
            long dist = curr.distance;
            int state = curr.state;

            if (wolfD[num][state] < dist) continue;

            for (Edge edge : graph.get(num)) {
                int nextState = 1 - state;

                long nextDist = dist + (state == 1 ? edge.weight / 2 : edge.weight * 2);

                if (nextDist < wolfD[edge.to][nextState]) {
                    wolfD[edge.to][nextState] = nextDist;
                    pq.offer(new Node(edge.to, nextDist, nextState));
                }
            }
        }
    }
}
