import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; ++i) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution() {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; ++i) {
            answer += A[i] * B[N - 1 - i];
        }

        System.out.print(answer);
    }
}
