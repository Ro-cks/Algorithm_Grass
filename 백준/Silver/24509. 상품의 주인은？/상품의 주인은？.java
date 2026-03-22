import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] students;
    static boolean[] awarded;
    static int[] result;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());

        students = new int[N][5];
        awarded = new boolean[N + 1];
        result = new int[4];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            students[i][0] = Integer.parseInt(st.nextToken()); // 번호
            students[i][1] = Integer.parseInt(st.nextToken()); // 국어
            students[i][2] = Integer.parseInt(st.nextToken()); // 영어
            students[i][3] = Integer.parseInt(st.nextToken()); // 수학
            students[i][4] = Integer.parseInt(st.nextToken()); // 과학
        }
    }

    static void solution() {
        for (int subject = 1; subject <= 4; ++subject) {
            int maxScore = -1;
            int winnerId = Integer.MAX_VALUE;

            for (int i = 0; i < N; ++i) {
                int id = students[i][0];
                int score = students[i][subject];

                // 이미 다른 과목에서 상을 받았다면 후보에서 제외
                if (awarded[id]) continue;

                // 점수가 더 높거나, (점수가 같으면서 번호가 더 작은 경우) 1등 갱신
                if (score > maxScore || (score == maxScore && id < winnerId)) {
                    maxScore = score;
                    winnerId = id;
                }
            }

            // 1등으로 뽑힌 학생은 수상 처리하고 결과 배열에 저장
            awarded[winnerId] = true;
            result[subject - 1] = winnerId;
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
    }
}
