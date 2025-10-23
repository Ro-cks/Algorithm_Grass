import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
    static int[] time = new int[100001]; // 시간 및 방문 여부 체크
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1. 배열 -1로 초기화 (미방문 표시)
        Arrays.fill(time, -1);

        // 2. 시작점 처리
        q.add(N);
        time[N] = 0;

        bfs();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int current = q.poll();

            // 5. 목표 도달 시
            if (current == K) {
                System.out.println(time[current]);
                return; // 탐색 종료
            }

            // 6. 다음 위치 탐색
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                // 7. 범위 확인 및 방문 확인
                if (next >= 0 && next <= 100000 && time[next] == -1) {
                    q.add(next);
                    time[next] = time[current] + 1; // 시간 기록
                }
            }
        }
    }
}
