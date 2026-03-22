import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] indegree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());

        graph = new ArrayList[N + 1];
        indegree = new int[N + 1]; // 자신보다 순위가 높은(자신을 이긴) 팀의 수

        for (int i = 1; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            ++indegree[v];
        }
    }

    static void solution() {
        Queue<Integer> q = new LinkedList<>();
        boolean isMultiple = false;

        // 진입 차수가 0인(아무에게도 지지 않은 1위 후보) 팀을 큐에 삽입
        for (int i = 1; i <= N; ++i) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            // 큐에 2개 이상의 팀이 대기 중이라면, 순위를 정할 경우의 수가 여러 개라는 뜻
            if (q.size() >= 2) {
                isMultiple = true;
            }

            int curr = q.poll();
            sb.append(curr).append('\n');

            for (int next : graph[curr]) {
                --indegree[next];

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (isMultiple) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        System.out.print(sb);
    }
}
