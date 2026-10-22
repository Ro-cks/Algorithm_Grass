import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int r = 0;
        int c = 0;
        int d = 0;
        int time = 0;
        boolean isReturn = false;

        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());
            d = "NESW".indexOf(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            for (int i = 0; i < dist; ++i) {
                r += dr[d];
                c += dc[d];
                ++time;

                if (r == 0 && c == 0) {
                    System.out.println(time);
                    System.exit(0);
                }
            }
        }

        System.out.println(-1);
    }
}