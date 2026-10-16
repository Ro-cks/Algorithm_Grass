import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, K;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = -1;
        int[] students = new int[N];
        for (int m = 0; m < M; ++m) {
            int num = Integer.parseInt(br.readLine()) - 1;

            ++students[num];
            if (students[num] == K) {
                answer = num + 1;

                break;
            }
        }

        System.out.println(answer);
    }
}