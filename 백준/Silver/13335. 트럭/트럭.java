import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int w;
    static int L;
    static int[] trucks;
    static Queue<Integer> bridge;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new int[n];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; ++i) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        bridge = new LinkedList<>();
        for (int i = 0; i < w; ++i) {
            // 다리 길이 만큼 0을 채움.
            // 다리 길이 w만큼 w대의 트럭이 오를 수 있기 때문
            bridge.offer(0);
        }
    }

    static void solution() throws IOException {
        int answer = 0;
        int weight = 0;

        for (int truck : trucks) {
            while (true) {
                ++answer; // 시간 경과

                // 시간이 지남 -> 맨 앞에 있는 트럭 or 0은 다리를 벗어남.
                weight -= bridge.poll();

                if (weight + truck <= L) {
                    bridge.offer(truck);
                    weight += truck;

                    break;
                } else { // 하중 초과 시
                    // 0을 밀어 넣고, 기존 트럭은 전진시키기
                    bridge.offer(0);
                }
            }
        }

        // 마지막 트럭이 다리에 오르는 순간 반복문이 종료되므로
        // 이 트럭이 다리를 빠져나오는데 걸리는 시간을 더해준당
        System.out.print(answer + w);
    }
}
