import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static List<Time> times;
    static PriorityQueue<Time> sortByEnd;

    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time t) {

            return Integer.compare(this.start, t.start);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        times = new ArrayList<>();
        sortByEnd = new PriorityQueue<>((o1, o2) -> {

            return Integer.compare(o1.end, o2.end);
        });

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Time t = new Time(start, end);
            times.add(t);
        }

        Collections.sort(times);
    }

    static void solution() {
        int answer = 0;
        sortByEnd.offer(times.get(0));

        for (int i = 1; i < times.size(); ++i) {
            Time time = times.get(i);

            if (time.start >= sortByEnd.peek().end) {
                sortByEnd.poll();
            }

            sortByEnd.offer(time);

            answer = Math.max(answer, sortByEnd.size());
        }

        System.out.print(answer);
    }
}
