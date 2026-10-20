import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_T = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] posA = new long[MAX_T + 1];
        int timeA = 1;
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for (int i = 0; i < t; ++i) {
                posA[timeA] = posA[timeA - 1] + v;
                ++timeA;
            }
        }

        long[] posB = new long[MAX_T + 1];
        int timeB = 1;
        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for (int i = 0; i < t; ++i) {
                posB[timeB] = posB[timeB - 1] + v;
                ++timeB;
            }
        }

        int leader = 0;
        int answer = 0;

        for (int i = 1; i < timeB; ++i) {
            if (posA[i] > posB[i]) {
                if (leader == 2) ++answer;
                leader = 1;
            } else if (posA[i] < posB[i]) {
                if (leader == 1) ++answer;
                leader = 2;
            }
        }

        System.out.println(answer);
    }
}