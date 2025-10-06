import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
    }

    private static void solution() throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {

                return Integer.compare(o1, o2);
            } else {

                return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });

        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine().trim());

            if (num != 0) {
                pq.add(num);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
