import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;
    static int[][] nums;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < M; ++j) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        K = Integer.parseInt(br.readLine().trim());
    }

    static void solution() throws IOException {
        for (int k = 0; k < K; ++k) {
            st = new StringTokenizer(br.readLine().trim());

            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;

            for (int row = i; row <= x; ++row) {
                for (int col = j; col <= y; ++col) {
                    sum += nums[row][col];
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
