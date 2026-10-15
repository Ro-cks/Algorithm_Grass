import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_T = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] posA = new int[MAX_T + 1];
        int time = 1;
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());

            char d = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            for (int i = 0; i < t; ++i) {
                posA[time] = posA[time - 1] + (d == 'R' ? 1 : -1);
                ++time;
            } 
        }

        int[] posB = new int[MAX_T + 1];
        time = 1;
        for (int m = 0; m < M; ++m) {
            st = new StringTokenizer(br.readLine());

            char d = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            for (int i = 0; i < t; ++i) {
                posB[time] = posB[time - 1] + (d == 'R' ? 1 : -1);
                ++time;
            } 
        }

        int answer = -1;
        for (int i = 1; i < time; ++i) {
            if (posA[i] == posB[i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}