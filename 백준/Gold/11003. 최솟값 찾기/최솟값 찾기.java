import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int L;

    static Deque<Node> dq;

    static class Node {
        int num;
        int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        dq = new LinkedList<>();
    }

    static void solution() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().num > val) {
                dq.removeLast();
            }

            dq.addLast(new Node(val, i));

            if (dq.getFirst().index <= i - L) {
                dq.removeFirst();
            }

            sb.append(dq.getFirst().num).append(' ');
        }

        System.out.print(sb);
    }
}
