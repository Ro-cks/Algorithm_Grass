import java.io.*;
import java.util.*;

public class Main {
    static final int OFFSET = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        int[][] map = new int[OFFSET * 2 + 1][OFFSET * 2 + 1];
        
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken()) + OFFSET;
            y1 = Integer.parseInt(st.nextToken()) + OFFSET;
            x2 = Integer.parseInt(st.nextToken()) + OFFSET;
            y2 = Integer.parseInt(st.nextToken()) + OFFSET;

            for (int x = x1; x < x2; ++x) {
                for (int y = y1; y < y2; ++y) {
                    map[x][y] = 1;
                }
            }
        }

        for (int i = 0; i < 201; ++i) {
            for (int j = 0; j < 201; ++j) {
                if (map[i][j] == 1) ++answer;
            }
        }

        System.out.println(answer);
    }
}