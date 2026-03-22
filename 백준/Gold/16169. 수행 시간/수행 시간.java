import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] rank;
    static int[] time;
    static int[] dp; // 각 컴퓨터의 최종 완료 시간
    static int[] indegree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());

        rank = new int[N + 1];
        time = new int[N + 1];
        dp = new int[N + 1];
        indegree = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            rank[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        // 다음 계급(rank + 1)으로 향하는 단방향 간선 생성
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (rank[j] == rank[i] + 1) {
                    graph[i].add(j);
                    ++indegree[j];
                }
            }
        }
    }

    static void solution() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; ++i) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph[curr]) {
                int transferTime = (curr - next) * (curr - next);

                // 다음 노드의 완료 시간 = 기존 기록 vs. (현재 노드 완료 시간 + 전송 시간 + 다음 노드 작업 시간) 중 최댓값
                dp[next] = Math.max(dp[next], dp[curr] + transferTime + time[next]);

                --indegree[next];

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // 모든 컴퓨터 중 가장 늦게 끝나는 시간이 전체 시스템의 수행 시간
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
