import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());

        maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        minHeap = new PriorityQueue<>();
    }

    static void solution() throws IOException {
        int maxHeapTop = 0;
        int minHeapTop = 0;
        boolean isMaxHeapNotEmpty = false;
        boolean isMinHeapNotEmpty = false;

        for (int i = 0; i < N; ++i) {
            int val = Integer.parseInt(br.readLine().trim());

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(val);
            } else {
                minHeap.offer(val);
            }

            if (!maxHeap.isEmpty()) {
                maxHeapTop = maxHeap.peek();
                isMaxHeapNotEmpty = true;
            }

            if (!minHeap.isEmpty()) {
                minHeapTop = minHeap.peek();
                isMinHeapNotEmpty = true;
            }

            if (isMaxHeapNotEmpty && isMinHeapNotEmpty) {
                if (maxHeapTop > minHeapTop) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }

            sb.append(maxHeap.peek()).append('\n');

            maxHeapTop = 0;
            minHeapTop = 0;
            isMaxHeapNotEmpty = false;
            isMinHeapNotEmpty = false;
        }

        System.out.print(sb);
    }
}
