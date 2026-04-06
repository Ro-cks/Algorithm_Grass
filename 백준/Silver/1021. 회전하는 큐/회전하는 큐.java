import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static LinkedList<Integer> q;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            q.offer(i);
        }

        st = new StringTokenizer(br.readLine().trim());
    }

    static void solution() {
        int answer = 0;

        for (int i = 0; i < M; ++i) {
            int target = Integer.parseInt(st.nextToken());

            int idx = q.indexOf(target);
            int size = q.size();

            if (idx <= size / 2) {
                for (int j = 0; j < idx; ++j) {
                    q.offerLast(q.pollFirst());
                    ++answer;
                }
            } else {
                for (int j = 0; j < size - idx; ++j) {
                    q.offerFirst(q.pollLast());
                    ++answer;
                }
            }

            q.pollFirst();
        }

        System.out.print(answer);
    }
}
