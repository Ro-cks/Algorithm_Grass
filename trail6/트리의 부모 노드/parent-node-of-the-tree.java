import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < N - 1; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        parent[1] = -1;
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; ++i) {
            sb.append(parent[i]).append('\n');
        }

        System.out.print(sb.toString());
    }

    private static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                if (parent[next] != 0) continue;
                parent[next] = curr;
                q.offer(next);
            }
        }
    }
}