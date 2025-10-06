import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        nums = new int[N];

        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine().trim());
            nums[i] = num;
        }
    }

    static void solution() throws IOException {
        Deque<Integer> dq = new ArrayDeque<>();
        int val = 1;

        for (int i = 0; i < N; ++i) {
            int num = nums[i];

            if (num >= val) {
                while (num >= val) {
                    dq.addLast(val++);
                    sb.append('+').append('\n');
                }

                dq.removeLast();
                sb.append('-').append('\n');
            } else {
                int su = dq.removeLast();

                if (su > num) {
                    System.out.print("NO");
                    System.exit(0);
                } else {
                    sb.append('-').append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
